package com.assign.entrance.common.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.json.JsonReadFeature;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.List;

public class JsonUtil {

    static ObjectMapper objectMapper = null;

    public static ObjectMapper createObjectMapper() {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }
        // 忽略实体中没有的字段
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // nul和空转换
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_ARRAY_AS_NULL_OBJECT, false);
        // 特殊字符和转义字符
        objectMapper.configure(JsonReadFeature.ALLOW_UNESCAPED_CONTROL_CHARS.mappedFeature(), true);
        // 启用没话输出
        objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        // 自动通过SPI发现jackson的module并注册
        objectMapper.findAndRegisterModules();
        return objectMapper;
    }

    private static <F> JavaType buildJavaType(Class<F> target) {
        return objectMapper.getTypeFactory().constructParametricType(List.class, target);
    }

    public static <F> List<F> readValueList(String resource, Class<F> target) {
        ObjectMapper objectMapper = createObjectMapper();
        List<F> list;
        try {
            list = objectMapper.readValue(resource, buildJavaType(target));
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return list;
    }
}
