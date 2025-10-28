package com.racacia.repository.model.enumerate;

/**
 * 城市等级
 */
public enum AreaClass {

    /*
     * 国
     */
    COUNTRY,
    /*
     * 省,自治区,直辖市,特别行政区
     */
    PROVINCE,
    /*
     * 地级市,地区,自治州,盟
     */
    CITY,
    /*
     * 市辖区,县级市,县,自治县,旗,自治旗,特区,林区
     */
    COUNTY,
    /*
     * 街道,镇,乡,民族乡,苏木,民族苏木,县辖区
     */
    TOWN,
    /*
     * 居委会,村委会
     */
    COMMITTEE;
}