package com.assign.entrance.model.dto;


import com.assign.entrance.model.bo.UrbanRuralBo;
import com.assign.entrance.model.po.UrbanRural;

import javax.validation.constraints.NotNull;

public class UrbanRuralDto extends UrbanRuralBo {

    @NotNull
    private Integer areaClass;

}
