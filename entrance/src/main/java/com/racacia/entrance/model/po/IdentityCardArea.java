package com.racacia.entrance.model.po;

import com.racacia.entrance.model.enumerate.NormalStatus;
import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.util.Date;

@TableName(value ="identity_card_area")
public class IdentityCardArea implements Serializable {
    /**
     * ID
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 身份证code
     */
    private String areaCode;

    /**
     * 身份证区域
     */
    private String areaName;

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

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    public Integer getId() {
        return id;
    }

    /**
     * ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 身份证code
     */
    public String getAreaCode() {
        return areaCode;
    }

    /**
     * 身份证code
     */
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    /**
     * 身份证区域
     */
    public String getAreaName() {
        return areaName;
    }

    /**
     * 身份证区域
     */
    public void setAreaName(String areaName) {
        this.areaName = areaName;
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