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
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UrbanRuralServiceImpl implements UrbanRuralService {

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
    private List<UrbanRuralBo> selectUrbanRural(List<UrbanRuralBo> urbanRuralBoList){
        for (UrbanRuralBo urbanRuralBo : urbanRuralBoList) {
            urbanRuralBo.setUrbanRuralBos(selectUrbanRural(urbanRuralBo));
        }
        return urbanRuralBoList;
    }

}
