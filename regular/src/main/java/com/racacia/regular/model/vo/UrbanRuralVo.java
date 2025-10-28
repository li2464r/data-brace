package com.racacia.regular.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.racacia.repository.model.enumerate.AreaClass;
import com.racacia.repository.model.enumerate.NormalStatus;
import com.racacia.repository.model.enumerate.UrbanruralClass;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UrbanRuralVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 5014379068811962022L;

    private Integer id;
    private Integer pid;
    private String areaCode;
    private String areaName;
    private String areaCodeParent;
    private String abbreviateEn;
    private String abbreviateCh;
    private AreaClass areaClass;
    private UrbanruralClass urbanRuralClass;
    private String postalCode;
    private NormalStatus normal;
    @JsonProperty("children")
    private List<UrbanRuralVo> children;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public String getAreaCodeParent() {
        return areaCodeParent;
    }

    public void setAreaCodeParent(String areaCodeParent) {
        this.areaCodeParent = areaCodeParent;
    }

    public String getAbbreviateEn() {
        return abbreviateEn;
    }

    public void setAbbreviateEn(String abbreviateEn) {
        this.abbreviateEn = abbreviateEn;
    }

    public String getAbbreviateCh() {
        return abbreviateCh;
    }

    public void setAbbreviateCh(String abbreviateCh) {
        this.abbreviateCh = abbreviateCh;
    }

    public AreaClass getAreaClass() {
        return areaClass;
    }

    public void setAreaClass(AreaClass areaClass) {
        this.areaClass = areaClass;
    }

    public UrbanruralClass getUrbanRuralClass() {
        return urbanRuralClass;
    }

    public void setUrbanRuralClass(UrbanruralClass urbanRuralClass) {
        this.urbanRuralClass = urbanRuralClass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public NormalStatus getNormal() {
        return normal;
    }

    public void setNormal(NormalStatus normal) {
        this.normal = normal;
    }

    public List<UrbanRuralVo> getChildren() {
        return children;
    }

    public void setChildren(List<UrbanRuralVo> children) {
        this.children = children;
    }
}
