package com.assign.entrance.model.bo;

import com.assign.entrance.model.po.UrbanRural;

import java.io.Serializable;
import java.util.List;

public class UrbanRuralBo extends UrbanRural implements Serializable {
    private static final long serialVersionUID = 5014379068811962022L;

    private List<UrbanRuralBo> urbanRuralBos;

    public List<UrbanRuralBo> getUrbanRuralBos() {
        return urbanRuralBos;
    }

    public void setUrbanRuralBos(List<UrbanRuralBo> urbanRuralBos) {
        this.urbanRuralBos = urbanRuralBos;
    }
}
