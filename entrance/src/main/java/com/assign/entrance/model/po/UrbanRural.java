package com.assign.entrance.model.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serial;
import java.io.Serializable;

@TableName("urban_rural")
@RedisHash
public class UrbanRural extends Model<UrbanRural> implements Serializable {
    @Serial
    private static final long serialVersionUID = 5014379068811962022L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private Integer pid;
    private String areaCode;
    private String areaName;
    private String areaCodeParent;
    private String abbreviateEn;
    private String abbreviateCh;
    private Integer areaClass;
    private String urbanRuralClass;
    private String postalCode;
    private String createDate;
    private Integer createUser;
    private String updateDate;
    private Integer updateUser;

    private Integer normal;

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

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Integer createUser) {
        this.createUser = createUser;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Integer updateUser) {
        this.updateUser = updateUser;
    }
}
