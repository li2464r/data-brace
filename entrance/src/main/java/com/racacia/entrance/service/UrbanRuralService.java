package com.racacia.entrance.service;


import com.racacia.entrance.model.dto.UrbanRuralDto;
import com.racacia.entrance.model.po.UrbanRural;
import com.racacia.entrance.model.vo.UrbanRuralVo;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

public interface UrbanRuralService extends IService<UrbanRural> {

    /**
     * 查询所有的层级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return {@link List<UrbanRuralVo>}
     */
    List<UrbanRuralVo> selectChildUrbanRural(UrbanRuralDto urbanRuralDto);

    /**
     * 查询所有的层级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return {@link List<UrbanRuralVo>}
     */
    List<UrbanRuralVo> selectLevelUrbanRural(UrbanRuralDto urbanRuralDto);

    UrbanRuralVo selectUrbanRuralById(Integer id);

    Object insertUrbanRural() throws Exception;

    String random(String address, Long pid);
}
