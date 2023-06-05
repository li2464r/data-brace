package com.assign.entrance.service;


import com.assign.entrance.model.dto.UrbanRuralDto;
import com.assign.entrance.model.vo.UrbanRuralVo;

import java.util.List;

public interface UrbanRuralService {

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
}
