package com.racacia.repository.model.bo;

import com.racacia.repository.model.po.UrbanRural;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UrbanRuralBo extends UrbanRural implements Serializable {
    @Serial
    private static final long serialVersionUID = 5014379068811962022L;

    private List<UrbanRuralBo> children;

    public List<UrbanRuralBo> getChildren() {
        return children;
    }

    public void setChildren(List<UrbanRuralBo> children) {
        this.children = children;
    }
}
