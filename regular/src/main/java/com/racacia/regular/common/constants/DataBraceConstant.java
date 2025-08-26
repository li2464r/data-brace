package com.racacia.regular.common.constants;

public class DataBraceConstant {

    /**
     * 城市等级
     */
    public enum URBANRURAL_AREACLASS {

        COUNTRY(0, "国"),
        PROVINCE(1, "省,自治区,直辖市,特别行政区"),
        CITY(2, "地级市,地区,自治州,盟"),
        COUNTY(3, "市辖区,县级市,县,自治县,旗,自治旗,特区,林区"),
        TOWN(4, "街道,镇,乡,民族乡,苏木,民族苏木,县辖区"),
        COMMITTEE(5, "居委会,村委会");

        URBANRURAL_AREACLASS(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public final int code;
        public final String description;

        public int getCode() {
            return code;
        }

        public String getDescription() {
            return description;
        }
    }

    /**
     * 城乡分类
     */
    public enum URBANRURAL_CLASS {

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

        URBANRURAL_CLASS(String code, String description) {
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
}