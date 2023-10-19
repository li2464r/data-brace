package com.assign.entrance.model.dto;


import com.assign.entrance.model.bo.UrbanRuralBo;
import jakarta.validation.constraints.NotNull;


public class UrbanRuralDto extends UrbanRuralBo {

    @NotNull
    private Integer id;
    private Integer areaClass;

}
