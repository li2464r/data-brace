package com.racacia.entrance.common.constants;

public class DataBraceConstant {

    /**
     * 城市等级
     *
     * @author <a href="mailto:li2464r@163.com">li2464r</a>
     * @date 2022/8/5 10:59
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


}