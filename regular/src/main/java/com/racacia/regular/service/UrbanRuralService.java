package com.racacia.regular.service;


import com.racacia.regular.model.dto.UrbanRuralDto;
import com.racacia.regular.model.vo.UrbanRuralVo;

import java.util.List;

public interface UrbanRuralService {

    /**
     * 查询所有的层级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return {@link List<UrbanRuralVo>}
     */
    List<UrbanRuralVo> selectChildUrbanRural(UrbanRuralDto urbanRuralDto);

    /**
     * 查询所有的层级城市
     *
     * @param urbanRuralDto {@link UrbanRuralDto}
     * @return {@link List<UrbanRuralVo>}
     */
    List<UrbanRuralVo> selectLevelUrbanRural(UrbanRuralDto urbanRuralDto);

    /**
     * 根据ID查询城市信息
     *
     * @param id 城市ID
     * @return 城市信息
     */
    UrbanRuralVo selectUrbanRuralById(Integer id);

    /**
     * 根据ID数组查询城市信息列表
     *
     * @param ids 城市ID数组
     * @return 城市信息列表
     */
    List<UrbanRuralVo> selectUrbanRuralByIds(List<Integer> ids);

    /**
     * 根据父ID查询城市信息
     *
     * @param pid 父级城市ID
     * @return 城市信息
     */
    List<UrbanRuralVo> selectUrbanRuralByPid(Integer pid);

    /**
     * 根据ID数组查询城市信息列表
     *
     * @param ids 城市ID数组
     * @return 城市信息列表
     */
    List<UrbanRuralVo> selectUrbanRuralByAreaClassIds(List<Integer> ids);

    /**
     * 插入城市信息
     *
     * @return 插入结果
     * @throws Exception 插入异常
     */
    Object insertUrbanRural() throws Exception;

    /**
     * 生成随机城市数据
     *
     * @param address 地址
     * @param pid 父级城市ID
     * @return 随机生成的结果
     */
    String random(String address, Integer pid);
}
