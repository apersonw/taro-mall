package org.rxjava.service.boot.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author happy 2019-04-16 23:26
 */
public class JsonUtils {
    public static ObjectMapper create() {
        return new ObjectMapper();
    }
}
