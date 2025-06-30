package com.racacia.regular.model.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class UrbanRuralVo implements Serializable {
    @Serial
    private static final long serialVersionUID = 5014379068811962022L;

    private Integer id;
    private String pid;
    private String areaCode;
    private String areaName;
    private String areaCodeParent;
    private String abbreviateEn;
    private String abbreviateCh;
    private Integer areaClass;
    private String urbanRuralClass;
    private String postalCode;
    private Integer normal;
    @JsonProperty("urbanRuralBos")
    private List<UrbanRuralVo> urbanRuralVos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
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

    public Integer getAreaClass() {
        return areaClass;
    }

    public void setAreaClass(Integer areaClass) {
        this.areaClass = areaClass;
    }

    public String getUrbanRuralClass() {
        return urbanRuralClass;
    }

    public void setUrbanRuralClass(String urbanRuralClass) {
        this.urbanRuralClass = urbanRuralClass;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public Integer getNormal() {
        return normal;
    }

    public void setNormal(Integer normal) {
        this.normal = normal;
    }

    public List<UrbanRuralVo> getUrbanRuralVos() {
        return urbanRuralVos;
    }

    public void setUrbanRuralVos(List<UrbanRuralVo> urbanRuralVos) {
        this.urbanRuralVos = urbanRuralVos;
    }

}
