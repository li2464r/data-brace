package com.racacia.repository.impl;

import com.racacia.repository.MiddlewareRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @author Administrator
 * @date 2021/12/28 0028 11:13
 */
@Service
public class MiddlewareRepositoryImpl implements MiddlewareRepository {
    private final RedisTemplate<String, Object> redisTemplate;
    private final ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;

    public MiddlewareRepositoryImpl(@Qualifier("RedisTemplate") RedisTemplate<String, Object> redisTemplate,
                                    ReactiveRedisTemplate<String, Object> reactiveRedisTemplate) {
        this.redisTemplate = redisTemplate;
        this.reactiveRedisTemplate = reactiveRedisTemplate;
    }

    @Override
    public RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    @Override
    public ReactiveRedisTemplate<String, Object> getReactiveRedisTemplate() {
        return reactiveRedisTemplate;
    }


}
