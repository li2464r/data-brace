package com.racacia.repository.config.cache;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * @date 2022/3/30 0030 10:37
 */
public class MybatisRedisCache implements Cache {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    private static final Map<String, ReactiveRedisTemplate<String, Object>> templateCache = new ConcurrentHashMap<>();

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final String id;

    private volatile ReactiveRedisTemplate<String, Object> reactiveRedisTemplate;


    public MybatisRedisCache(String id) {
        this.id = id;
    }

    private ReactiveRedisTemplate<String, Object> getReactiveRedisTemplate() {
        if (null == reactiveRedisTemplate) {
            synchronized (this) {
                if (null == reactiveRedisTemplate) {
                    logger.info("Lazy loading ReactiveRedisTemplate for cache: {}", id);
                    reactiveRedisTemplate = templateCache.computeIfAbsent(id, key ->
                            SpringBeanContext.getBean("ReactiveRedisTemplate", ReactiveRedisTemplate.class)
                    );
                }
            }
        }
        return reactiveRedisTemplate;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object hashKey, Object hashValue) {
        getReactiveRedisTemplate().expire(id, Duration.ofMinutes(3)).subscribe();
        getReactiveRedisTemplate().opsForHash().put(id, hashKey, hashValue).subscribe();
    }

    @Override
    public Object getObject(Object hashKey) {
        try {
            return getReactiveRedisTemplate().opsForHash().get(id, hashKey).toFuture().get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Failed to get object", e);
            return null;
        } catch (ExecutionException e) {
            logger.error("Failed to get object", e);
            return null;
        }
    }

    @Override
    public Object removeObject(Object hashKey) {
        return getReactiveRedisTemplate().opsForHash().remove(id, hashKey).subscribe();
    }

    @Override
    public void clear() {
        getReactiveRedisTemplate().delete(id).subscribe();
    }

    @Override
    public int getSize() {
        Flux<Map.Entry<Object, Object>> entryFlux = getReactiveRedisTemplate().opsForHash().entries(id);
        Map<Object, Object> entries = entryFlux.toStream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        return entries.size();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }
}
