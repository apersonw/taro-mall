package org.rxjava.common.core.api;

import reactor.core.publisher.Mono;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author happy 2019-04-29 11:06
 * 内部Http客户端
 */
public interface InnerHttpClient {
    <T> Mono<T> request(String method, String uri, List<Map<String, Object>> form, Type type);
}
