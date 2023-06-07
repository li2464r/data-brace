package com.assign.entrance.base.redis.serializer;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.util.Assert;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Locale;

public class CustomRedisSerializer implements RedisSerializer<String> {

    private final Charset charset;
    private final String prefix;

    public static CustomRedisSerializer prefix(String prefix) {
        return prefix(StandardCharsets.UTF_8, prefix);
    }

    public static CustomRedisSerializer prefix(Charset charset, String prefix) {
        return new CustomRedisSerializer(charset, prefix);
    }

    CustomRedisSerializer(Charset charset, String prefix) {
        Assert.notNull(charset, "Charset must not be null!");
        Assert.notNull(prefix, "prefix must not be null!");
        this.charset = charset;
        this.prefix = prefix;
    }

    @Override
    public byte[] serialize(String string) throws SerializationException {
        return (string == null ? null : (prefix + string).toUpperCase(Locale.ROOT).getBytes(charset));
    }

    @Override
    public String deserialize(byte[] bytes) throws SerializationException {
        return (bytes == null ? null : (prefix + new String(bytes, charset)).toUpperCase(Locale.ROOT));
    }
}
