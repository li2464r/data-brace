package com.assign.entrance.service.impl;


import com.assign.entrance.common.bean.BeanUtil;
import com.assign.entrance.common.constants.DataBraceConstant;
import com.assign.entrance.mapper.UrbanRuralMapper;
import com.assign.entrance.model.bo.UrbanRuralBo;
import com.assign.entrance.model.dto.UrbanRuralDto;
import com.assign.entrance.model.po.UrbanRural;
import com.assign.entrance.model.vo.UrbanRuralVo;
import com.assign.entrance.service.UrbanRuralService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import net.sourceforge.pinyin4j.PinyinHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class UrbanRuralServiceImpl extends ServiceImpl<UrbanRuralMapper, UrbanRural> implements UrbanRuralService {

    Logger logger = LoggerFactory.getLogger(getClass());

    private final UrbanRuralMapper urbanRuralMapper;

    public UrbanRuralServiceImpl(UrbanRuralMapper urbanRuralMapper) {
        this.urbanRuralMapper = urbanRuralMapper;
    }

    @Override
    public List<UrbanRuralVo> selectChildUrbanRural(UrbanRuralDto urbanRuralDto) {
        // 默认查询第一级
        int areaClass = DataBraceConstant.URBANRURAL_AREACLASS.COUNTRY.code;
        if (null != urbanRuralDto && null != urbanRuralDto.getAreaClass()) {
            areaClass = urbanRuralDto.getAreaClass();
        }
        // 查询条件
        QueryWrapper<UrbanRural> wrapper = new QueryWrapper<>();
        wrapper.eq("area_class", areaClass);
        wrapper.eq("normal", DataBraceConstant.NORMAL.NORMAL.getCode());

        List<UrbanRuralBo> urbanRuralBoList = BeanUtil.copyList(urbanRuralMapper.selectList(wrapper), UrbanRuralBo.class);

        List<UrbanRuralBo> urbanRuralBoList1 = selectUrbanRural(urbanRuralBoList);

        return BeanUtil.copyNestList(urbanRuralBoList1, UrbanRuralVo.class);
    }

    @Override
    public List<UrbanRuralVo> selectLevelUrbanRural(UrbanRuralDto urbanRuralDto) {
        QueryWrapper<UrbanRural> wrapper = new QueryWrapper<>();
        wrapper.eq("area_class", urbanRuralDto.getAreaClass());
        wrapper.eq("normal", DataBraceConstant.NORMAL.NORMAL.getCode());
        return BeanUtil.copyList(urbanRuralMapper.selectList(wrapper), UrbanRuralVo.class);
    }

    /**
     * 递归查询子城市
     */
    private List<UrbanRuralBo> selectUrbanRural(UrbanRuralBo urbanRuralBo) {
        if (null == urbanRuralBo) {
            return new ArrayList<>();
        }
        QueryWrapper<UrbanRural> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", urbanRuralBo.getId());
        wrapper.eq("normal", DataBraceConstant.NORMAL.NORMAL.getCode());
        wrapper.le("area_class", DataBraceConstant.URBANRURAL_AREACLASS.COUNTY.getCode());
        List<UrbanRural> urbanRuralList = urbanRuralMapper.selectList(wrapper);
        if (urbanRuralList.size() == 0) {
            return null;
        }
        List<UrbanRuralBo> urbanRuralBoList = BeanUtil.copyList(urbanRuralList, UrbanRuralBo.class);
        selectUrbanRural(urbanRuralBoList);
        return urbanRuralBoList;
    }

    /**
     * 递归查询子城市
     */
    private List<UrbanRuralBo> selectUrbanRural(List<UrbanRuralBo> urbanRuralBoList) {
        urbanRuralBoList.parallelStream().forEach(urbanRuralBo -> urbanRuralBo.setUrbanRuralBos(selectUrbanRural(urbanRuralBo)));
        return urbanRuralBoList;
    }

    // ----------------------------------------------------------------

    String reg = "[^一-龥]";

    @Override
//    @Transactional(rollbackFor = Exception.class)
    public Object insertUrbanRural() throws Exception {
        int level = 0;
        // 保存
        UrbanRural urbanRural = saveOrUpdate(0, null, "中国", null, null, null);
        // 获取全国各个省级信息
        Document connect = connect("http://www.stats.gov.cn/sj/tjbz/tjyqhdmhcxhfdm/2022/");
        Elements provinceElements = connect.select("tr.provincetr");
        // 获取省
        provinceInfo(urbanRural.getId(), urbanRural.getAreaCode(), provinceElements, level + 1);
        return true;
    }

    private UrbanRural saveOrUpdate(Integer pid, String areaCode, String areaName, String areaCodeParent, Integer areaClass, String urbanRuralClass) {
        // 先查询是否存在
        QueryWrapper<UrbanRural> urbanRuralQueryWrapper = new QueryWrapper<>();
        urbanRuralQueryWrapper.eq("area_name", areaName);
        urbanRuralQueryWrapper.eq(null != areaCode, "area_code", areaCode);
        urbanRuralQueryWrapper.eq("normal", 1);
        UrbanRural urbanRural = baseMapper.selectOne(urbanRuralQueryWrapper);
        if (null == urbanRural) {
            urbanRural = new UrbanRural();
            urbanRural.setPid(pid);
            urbanRural.setAreaCode(areaCode);
            urbanRural.setAreaName(areaName);
            urbanRural.setAreaCodeParent(areaCodeParent);
            urbanRural.setAbbreviateEn(toCharacterInitials(areaName.replaceAll(reg, "")));
            urbanRural.setAreaClass(areaClass);
            urbanRural.setUrbanRuralClass(urbanRuralClass);
            this.saveOrUpdate(urbanRural);
        }
        return urbanRural;
    }

    // 获取省
    private void provinceInfo(Integer parentId, String areaCodeParent, Elements provinceElements, int level) throws Exception {
        for (Element provinceElement : provinceElements) {
            // 省
            Elements elements = provinceElement.select("a");
            for (Element element : elements) {
                // 替换a标签
                String provinceName = element.toString().replaceAll(reg, "");
                if (provinceName.contains("河北省")) {
                    // 保存
                    UrbanRural urbanRural = saveOrUpdate(parentId, null, provinceName, areaCodeParent, level, null);
                    cityInfo(urbanRural.getId(), urbanRural.getAreaCodeParent(), element, level + 1);
                }
            }
        }
    }

    // 获取市
    private void cityInfo(Integer parentId, String areaCodeParent, Element provinceElement, int level) throws Exception {
        // 获取子级城市
        Document doc = connect(provinceElement.attr("abs:href"));
        Elements cityElements = doc.select("tr.citytr");
        for (Element cityElement : cityElements) {
            String cityCode = cityElement.select("td").first().text();
            String cityName = cityElement.select("td").last().text();
            if (cityName.contains("市辖区")) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("110100000000");
                arrayList.add("120100000000");
                arrayList.add("310100000000");
                arrayList.add("500100000000");
                // 判断是不是北京的市辖区
                if (!arrayList.contains(cityCode)) {
                    continue;
                }
            }
            if (!cityName.contains("邢台市")) {
                continue;
            }
            // 保存
            UrbanRural urbanRural = saveOrUpdate(parentId, cityCode, cityName, areaCodeParent, level, null);
            // 获取下一级
            Elements select = cityElement.select("a");
            if (select.size() != 0) {
                countyInfo(urbanRural.getId(), urbanRural.getAreaCode(), select.last(), level + 1);
            }
        }
    }

    // 获取县
    private void countyInfo(Integer parentId, String areaCodeParent, Element cityElement, int level) throws Exception {
        // 获取子级城市
        Document doc = connect(cityElement.attr("abs:href"));
        Elements countyElements = doc.select("tr.countytr");
        for (Element countyElement : countyElements) {
            String cityCode = countyElement.select("td").first().text();
            String cityName = countyElement.select("td").last().text();
            if (cityName.contains("市辖区")) {
                ArrayList<String> arrayList = new ArrayList<>();
                arrayList.add("110100000000");
                arrayList.add("120100000000");
                arrayList.add("310100000000");
                arrayList.add("500100000000");
                // 判断是不是北京的市辖区
                if (!arrayList.contains(cityCode)) {
                    continue;
                }
            }
            // 保存
            UrbanRural urbanRural = saveOrUpdate(parentId, cityCode, cityName, areaCodeParent, level, null);
            // 获取下一级
            Elements select = countyElement.select("a");
            if (select.size() != 0) {
                townInfo(urbanRural.getId(), urbanRural.getAreaCode(), select.last(), level + 1);
            }
        }
    }

    // 获取镇
    private void townInfo(Integer parentId, String areaCodeParent, Element countyElement, int level) throws Exception {
        // 获取子级城市
        Document doc = connect(countyElement.attr("abs:href"));
        Elements townElements = doc.select("tr.towntr");
        for (Element townElement : townElements) {
            String cityCode = townElement.select("td").first().text();

            String cityName = townElement.select("td").last().text();
            // 保存
            UrbanRural urbanRural = saveOrUpdate(parentId, cityCode, cityName, areaCodeParent, level, null);
            // 获取下一级
            Elements select = townElement.select("a");
            if (select.size() != 0) {
                villageInfo(urbanRural.getId(), urbanRural.getAreaCode(), select.last(), level + 1);
            }
        }
    }

    // 获取村
    private void villageInfo(Integer parentId, String areaCodeParent, Element townElement, int level) throws Exception {
        // 获取子级城市
        Document doc = connect(townElement.attr("abs:href"));
        Elements villageElements = doc.select("tr.villagetr");
        villageElements.parallelStream().forEach(villageElement -> {
            String cityCode = villageElement.select("td").first().text();
            String cityName = villageElement.select("td").last().text();
            String villageCode = "";
            if (level == 5) {
                villageCode = villageElement.select("td").get(1).text();
            }
            // 保存
            saveOrUpdate(parentId, cityCode, cityName, areaCodeParent, level, villageCode);
        });
    }

    private Document connect(String url) throws Exception {
        Thread.sleep(500);
        return Jsoup.connect(url).timeout(30 * 1000).get();
    }

    private String toCharacterInitials(String name) {
        StringBuilder s = new StringBuilder();
        for (char c : name.toCharArray()) {
            if (c == '鐣') {
                s.append("c");
                continue;
            }
            String[] strings = PinyinHelper.toHanyuPinyinStringArray(c);
            String substring = strings[0].substring(0, 1);
            s.append(substring);
        }
        return s.toString().toUpperCase(Locale.ROOT);
    }
}