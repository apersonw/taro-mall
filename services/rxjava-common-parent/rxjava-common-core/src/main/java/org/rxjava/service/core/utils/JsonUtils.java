package org.rxjava.service.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * @author happy 2019-04-16 23:26
 */
public class JsonUtils {
    public static final ObjectMapper DEFAULT_MAPPER = new ObjectMapper();

    public static ObjectMapper create() {
        return new ObjectMapper();
    }

    /**
     * 反序列化Json字符串
     */
    public static <T> T deserialize(String json, Class<T> valueType) {
        try {
            return DEFAULT_MAPPER.readValue(json, valueType);
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
