package com.assign.entrance.mapper;


import com.assign.entrance.model.po.UrbanRural;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

@Mapper
// @CacheNamespace(implementation = MybatisRedisCache.class, eviction = MybatisRedisCache.class)
public interface UrbanRuralMapper extends BaseMapper<UrbanRural> {
}
