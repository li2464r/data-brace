package com.racacia.middleware.redis.config;

import com.racacia.middleware.redis.serializer.KeyRedisSerializer;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Component;


/**
 * @author Administrator
 * @date 2021/12/28 0028 18:18
 */
@Configurable
@EnableAutoConfiguration
@Component
public class RedisConfig {

    public static final String REDIS_TEMPLATE = "RedisTemplate";
    public static final String REACTIVE_REDIS_TEMPLATE = "ReactiveRedisTemplate";

    @Value("${spring.application.name:REDIS}")
    private String applicationName;

    /**
     * @param redisConnectionFactory {@link RedisConnectionFactory} 获取连接配置
     * @return RedisTemplate<String, Object> {@link RedisTemplate<>} 继承
     * @author R
     * @date 2021/12/30 0030 10:14
     */
    @Bean(REDIS_TEMPLATE)
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        // 配置连接
        redisTemplate.setConnectionFactory(redisConnectionFactory);
        // key 前缀
        // 设置key的序列化方式(可自定义序列化方式)
        redisTemplate.setKeySerializer(new KeyRedisSerializer(applicationName));
        // 设置value的序列化方式(可自定义序列化方式)
        redisTemplate.setValueSerializer(RedisSerializer.json());
        // 设置hash类型的key序列化方式
        redisTemplate.setHashKeySerializer(RedisSerializer.java());
        // 设置hash类型的value序列化方式
        redisTemplate.setHashValueSerializer(RedisSerializer.json());
        return redisTemplate;
    }

    /**
     * @param reactiveRedisConnectionFactory {@link ReactiveRedisConnectionFactory} 获取连接配置
     * @return ReactiveRedisTemplate<String, Object> 实现 {@link ReactiveRedisTemplate <>}
     * @author <a href="mailto:li2464r@163.com">R</a>
     * @date 2024/3/8 008 18:06
     */
    @Bean(REACTIVE_REDIS_TEMPLATE)
    public ReactiveRedisTemplate<String, Object> reactiveRedisTemplate(ReactiveRedisConnectionFactory reactiveRedisConnectionFactory) {
        RedisSerializationContext.RedisSerializationContextBuilder<String, Object> redisSerializationContextBuilder = RedisSerializationContext.newSerializationContext();
        // key 前缀
        // 设置key的序列化方式(可自定义序列化方式)
        redisSerializationContextBuilder.key(KeyRedisSerializer.key(applicationName));
        // 设置value的序列化方式(可自定义序列化方式)
        redisSerializationContextBuilder.value(RedisSerializer.json());

        // 设置hash类型的key序列化方式
        redisSerializationContextBuilder.hashKey(RedisSerializer.java());

        // 设置hash类型的value序列化方式
        redisSerializationContextBuilder.hashValue(RedisSerializer.java());
        // redisSerializationContextBuilder.hashValue(new Jackson2JsonRedisSerializer<>(buildHashValueObjectMapper(), Object.class));
        // redisSerializationContextBuilder.hashValue(RedisSerializer.json());

        RedisSerializationContext<String, Object> build = redisSerializationContextBuilder.build();
        return new ReactiveRedisTemplate<>(reactiveRedisConnectionFactory, build);
    }
}

