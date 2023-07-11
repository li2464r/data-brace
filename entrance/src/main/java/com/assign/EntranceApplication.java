package com.assign;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@SpringBootApplication
@EnableRedisRepositories(redisTemplateRef = "RedisTemplate")
public class EntranceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EntranceApplication.class);
    }
}
