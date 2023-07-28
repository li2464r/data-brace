package com.assign.entrance.base.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Map;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Administrator
 * @date 2022/3/30 0030 10:37
 */


public class MybatisRedisCache implements Cache {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final RedisTemplate<String, Object> redisTemplate;

    private final String id;

    public MybatisRedisCache(final String id) {
        this.id = id;
        this.redisTemplate = SpringBeanContext.getBean("RedisTemplate");
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        // logger.info("RedisCache.putObject: id:{}", id);
        redisTemplate.boundHashOps(id).put(key, value);
    }

    @Override
    public Object getObject(Object key) {
        // logger.info("RedisCache.getObject: id:{}", id);
        return redisTemplate.boundHashOps(id).get(key);
    }

    @Override
    public Object removeObject(Object key) {
        // logger.info("RedisCache.removeObject: id:{}", id);
        return redisTemplate.boundHashOps(id).delete(key);
    }

    @Override
    public void clear() {
        // logger.info("RedisCache.clear: id:{}", id);
        redisTemplate.delete(id);
    }

    @Override
    public int getSize() {
        Map<Object, Object> entries = redisTemplate.boundHashOps(id).entries();
        return null == entries ? 0 : entries.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
