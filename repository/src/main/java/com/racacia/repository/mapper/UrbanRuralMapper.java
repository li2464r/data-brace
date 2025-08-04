package com.racacia.repository.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.racacia.repository.config.cache.MybatisRedisCache;
import com.racacia.repository.model.po.UrbanRural;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;

@Mapper
@CacheNamespace(implementation = MybatisRedisCache.class, eviction = MybatisRedisCache.class)
public interface UrbanRuralMapper extends BaseMapper<UrbanRural> {
}
