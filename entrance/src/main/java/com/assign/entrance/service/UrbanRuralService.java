package com.assign.entrance.service;


import com.assign.entrance.model.dto.UrbanRuralDto;
import com.assign.entrance.model.vo.UrbanRuralVo;

import java.util.List;

public interface UrbanRuralService {

    List<UrbanRuralVo> selectChildUrbanRural(UrbanRuralDto urbanRuralDto);

    List<UrbanRuralVo> selectLevelUrbanRural(UrbanRuralDto urbanRuralDto);
}
