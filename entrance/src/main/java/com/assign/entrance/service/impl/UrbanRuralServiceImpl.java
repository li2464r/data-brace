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
import org.springframework.stereotype.Service;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.*;

@Service
public class UrbanRuralServiceImpl extends ServiceImpl<UrbanRuralMapper, UrbanRural> implements UrbanRuralService {

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
        for (UrbanRuralBo urbanRuralBo : urbanRuralBoList) {
            urbanRuralBo.setUrbanRuralBos(selectUrbanRural(urbanRuralBo));
        }
        return urbanRuralBoList;
    }

    // ----------------------------------------------------------------

    Map<Integer, String> map = new HashMap<>();
    String reg = "[^\u4e00-\u9fa5]";

    @Override
    public Object insertUrbanRural() throws Exception {
        // 初始化
        map.put(1, "provincetr");
        map.put(2, "citytr");
        map.put(3, "countytr");
        map.put(4, "towntr");
        map.put(5, "villagetr");

        int level = 1;
        // 获取全国各个省级信息
        // http://www.stats.gov.cn/sj/tjbz/tjyqhdmhcxhfdm/2022/
        Document connect = connect("http://www.stats.gov.cn/sj/tjbz/tjyqhdmhcxhfdm/2022/");
        Elements rowProvince = connect.select("tr." + map.get(level));
        for (Element provinceElement : rowProvince) {
            // 省
            Elements elements = provinceElement.select("a");
            for (Element element : elements) {
                // 替换a标签
                String provinceName = element.toString().replaceAll(reg, "");
                if (provinceName.contains("山西")) {
                    // SET
                    UrbanRural urbanRural = new UrbanRural();
                    urbanRural.setPid(0);
                    urbanRural.setAreaName(provinceName);
                    urbanRural.setAreaClass(level);
                    urbanRural.setAbbreviateEn(toCharacterInitials(provinceName));
                    this.saveOrUpdate(urbanRural);
                    // ADD
                    printInfoProvince(urbanRural.getId(), urbanRural.getId(), element, level + 1);
                }
            }
        }
        return null;
    }

    private String toCharacterInitials(String name) {
        StringBuilder s = new StringBuilder();
        for (char c : name.toCharArray()) {
            String[] strings = PinyinHelper.toHanyuPinyinStringArray(c);
            String substring = strings[0].substring(0, 1);
            s.append(substring);
        }
        return s.toString().toUpperCase(Locale.ROOT);
    }

    private void printInfoProvince(Integer id, Integer parentId, Element element, int level) throws Exception {
        parentId = id;
        // 获取子级城市
        Document doc = connect(element.attr("abs:href"));
        Elements childElement = doc.select("tr." + map.get(level));
        for (Element item : childElement) {
            id++;
            String cityCode = item.select("td").first().text();
            String cityName = item.select("td").last().text();
            String villageCode = "";
            if (level == 5) {
                villageCode = item.select("td").get(1).text();
            }
            if (!cityName.contains("市辖区") || cityCode.contains("110100000000")) {
                UrbanRural urbanRural = new UrbanRural();
                urbanRural.setId(id);
                urbanRural.setPid(parentId);
                urbanRural.setAreaCode(cityCode);
                urbanRural.setAreaName(cityName);
                urbanRural.setAreaClass(level);
                urbanRural.setUrbanRuralClass(villageCode);
                urbanRural.setAbbreviateEn(toCharacterInitials(cityName));
                this.saveOrUpdate(urbanRural);
            }

            // 在递归调用的时候，这里是判断是否是村一级的数据，村一级的数据没有a标签
            Elements select = item.select("a");
            if (select.size() != 0) {
                printInfoProvince(id, parentId, select.last(), level + 1);
            }
        }
    }

    private Document connect(String url) throws Exception {
        Thread.sleep(500);
        Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("114.102.45.178", 8089));
        return Jsoup.connect(url).proxy(proxy).timeout(30 * 1000).get();
    }

}
