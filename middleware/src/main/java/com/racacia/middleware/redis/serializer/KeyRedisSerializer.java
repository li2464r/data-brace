package com.racacia.middleware.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public record KeyRedisSerializer(Charset charset, String prefix) implements RedisSerializer<String> {

    public static KeyRedisSerializer key(String prefix) {
        return new KeyRedisSerializer(StandardCharsets.UTF_8, prefix);
    }

    public KeyRedisSerializer(String prefix) {
        this(StandardCharsets.UTF_8, prefix);
    }

    public KeyRedisSerializer(Charset charset, String prefix) {
        Assert.notNull(charset, "charset must not be null!");
        Assert.notNull(prefix, "prefix must not be null!");
        this.charset = charset;
        this.prefix = prefix + ":";
    }

    public byte[] serialize(String string) throws SerializationException {
        return (string == null ? null : (prefix + string).toUpperCase(Locale.ROOT).getBytes(charset));
    }

    public String deserialize(byte[] bytes) throws SerializationException {
        return (bytes == null ? null : (prefix + new String(bytes, charset)).toUpperCase(Locale.ROOT));
    }

}
