package com.racacia.middleware.repository;

import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author Administrator
 */
public interface MiddlewareRepository {

    /**
     * 获取redis数据仓库
     *
     * @return {@link RedisTemplate}
     */
    RedisTemplate<String, Object> getRedisTemplate();

    /**
     * 获取redis数据仓库
     *
     * @return {@link ReactiveRedisTemplate}
     */
    ReactiveRedisTemplate<String, Object> getReactiveRedisTemplate();
}
