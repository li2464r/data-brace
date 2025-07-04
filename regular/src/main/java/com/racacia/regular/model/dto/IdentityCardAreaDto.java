package com.racacia.regular.model.dto;

/**
 * @author <a href="mailto:jieqiang.li-ext@iakng.com">jieqiang.li</a>
 * @date 2024-10-15 17:29
 */
public class IdentityCardAreaDto {

    /**
     * 身份证code
     */
    private String areaCode;

    /**
     * 身份证区域
     */
    private String areaName;

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

}
