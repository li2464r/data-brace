package com.racacia.repository.model.po;

import com.baomidou.mybatisplus.annotation.*;
import com.racacia.repository.model.enumerate.NormalStatus;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

/**
 * 城市表
 *
 * @TableName urban_rural
 */
@TableName(value = "urban_rural")
public class UrbanRural implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 父ID
     */
    private Long pid;

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
    @TableLogic(value = "'ENABLE'", delval = "'DISABLE'")
    @EnumValue
    private NormalStatus normal;

    @Serial
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    public Long getId() {
        return id;
    }

    /**
     * ID
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 父ID
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 父ID
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 代码
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 代码
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 名称
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 名称
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    /**
     * 上一级代码
     */
    public String getAreaCodeParent() {
        return areaCodeParent;
    }

    /**
     * 上一级代码
     */
    public void setAreaCodeParent(String areaCodeParent) {
        this.areaCodeParent = areaCodeParent;
    }

    /**
     * 英文缩写
     */
    public String getAbbreviateEn() {
        return abbreviateEn;
    }

    /**
     * 英文缩写
     */
    public void setAbbreviateEn(String abbreviateEn) {
        this.abbreviateEn = abbreviateEn;
    }

    /**
     * 中文缩写
     */
    public String getAbbreviateCh() {
        return abbreviateCh;
    }

    /**
     * 中文缩写
     */
    public void setAbbreviateCh(String abbreviateCh) {
        this.abbreviateCh = abbreviateCh;
    }

    /**
     * 城市等级: 0:国;1:省,自治区,直辖市,特别行政区;2:地级市,地区,自治州,盟;3:市辖区,县级市,县,自治县,旗,自治旗,特区,林区;4:街道,镇,乡,民族乡,苏木,民族苏木,县辖区;5:居委会,村委会;
     */
    public String getAreaClass() {
        return areaClass;
    }

    /**
     * 城市等级: 0:国;1:省,自治区,直辖市,特别行政区;2:地级市,地区,自治州,盟;3:市辖区,县级市,县,自治县,旗,自治旗,特区,林区;4:街道,镇,乡,民族乡,苏木,民族苏木,县辖区;5:居委会,村委会;
     */
    public void setAreaClass(String areaClass) {
        this.areaClass = areaClass;
    }

    /**
     * 城乡等级: 100:城镇;110:城区;111:主城区;112:城乡结合区;120:镇区;121:镇中心区;122:镇乡结合区;123:特殊区域;200:乡村;210:乡中心区;220:村庄;
     */
    public String getUrbanRuralClass() {
        return urbanRuralClass;
    }

    /**
     * 城乡等级: 100:城镇;110:城区;111:主城区;112:城乡结合区;120:镇区;121:镇中心区;122:镇乡结合区;123:特殊区域;200:乡村;210:乡中心区;220:村庄;
     */
    public void setUrbanRuralClass(String urbanRuralClass) {
        this.urbanRuralClass = urbanRuralClass;
    }

    /**
     * 邮编
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 邮编
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 创建时间
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 创建人
     */
    public Integer getCreateUser() {
        return createUser;
    }

    /**
     * 创建人
     */
    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    /**
     * 更新时间
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * 更新人
     */
    public Integer getUpdateUser() {
        return updateUser;
    }

    /**
     * 更新人
     */
    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }

    /**
     * 状态: 0:停用;1:启用;
     */
    public NormalStatus getNormal() {
        return normal;
    }

    /**
     * 状态: 0:停用;1:启用;
     */
    public void setNormal(NormalStatus normal) {
        this.normal = normal;
    }

}
