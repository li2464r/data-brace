package com.racacia.repository.model.bo;

import com.racacia.repository.model.enumerate.NormalStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UrbanRuralBo implements Serializable {

    /**
     * ID
     */
    private Integer id;

    /**
     * 父ID
     */
    private Integer pid;

    /**
     * 代码
     */
    private String areaCode;

    /**
     * 名称
     */
    private String areaName;

    /**
     * 上一级代码
     */
    private String areaCodeParent;

    /**
     * 英文缩写
     */
    private String abbreviateEn;

    /**
     * 中文缩写
     */
    private String abbreviateCh;

    /**
     * 城市等级: 0:国;1:省,自治区,直辖市,特别行政区;2:地级市,地区,自治州,盟;3:市辖区,县级市,县,自治县,旗,自治旗,特区,林区;4:街道,镇,乡,民族乡,苏木,民族苏木,县辖区;5:居委会,村委会;
     */
    private String areaClass;

    /**
     * 城乡等级: 100:城镇;110:城区;111:主城区;112:城乡结合区;120:镇区;121:镇中心区;122:镇乡结合区;123:特殊区域;200:乡村;210:乡中心区;220:村庄;
     */
    private String urbanRuralClass;

    /**
     * 邮编
     */
    private String postalCode;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人
     */
    private Integer createUser;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 更新人
     */
    private Integer updateUser;

    /**
     * 状态: 0:停用;1:启用;
     */
    private NormalStatus normal;

    @Serial
    private static final long serialVersionUID = 1L;

    private List<UrbanRuralBo> children;

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

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

    public String getAreaClass() {
        return areaClass;
    }

    public void setAreaClass(String areaClass) {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    public NormalStatus getNormal() {
        return normal;
    }

    public void setNormal(NormalStatus normal) {
        this.normal = normal;
    }

    public List<UrbanRuralBo> getChildren() {
        return children;
    }

    public void setChildren(List<UrbanRuralBo> children) {
        this.children = children;
    }
}
