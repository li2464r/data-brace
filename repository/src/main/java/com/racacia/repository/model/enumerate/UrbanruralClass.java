package com.racacia.repository.model.enumerate;

/**
 * 城乡分类
 */
public enum UrbanruralClass {

    TOWN("100", "城镇"),
    URBAN("110", "城区"),
    MAIN_URBAN("111", "主城区"),
    URBAN_RURAL_INTEGRATION("112", "城乡结合区"),
    TOWN_AREA("120", "镇区"),
    TOWN_CENTER("121", "镇中心区"),
    TOWN_RURAL_INTEGRATION("122", "镇乡结合区"),
    SPECIAL_AREA("123", "特殊区域"),
    RURAL("200", "乡村"),
    RURAL_CENTER("210", "乡中心区"),
    VILLAGE("220", "村庄");

    UrbanruralClass(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public final String code;
    public final String description;

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}