package org.rxjava.api.user;

import lombok.Data;
import org.rxjava.apikit.client.ClientAdapter;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.HttpMethod;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

/**
 * @author happy 2019-01-21 20:27
 * HttpClient适配器
 */
@Data
public class ReactiveHttpClientAdapter implements ClientAdapter {
    private WebClient webClient;
    private WebClient.Builder webClientBuilder;
    private String serviceId;
    /**
     * 类型转换函数
     */
    private Function<Object, String> typeConvert;
    private String token;

    @PostConstruct
    public void init() {

    }

    private ReactiveHttpClientAdapter(WebClient.Builder webClientBuilder, String serviceId) {
        this.serviceId = serviceId;
        this.webClientBuilder = webClientBuilder;
        webClient = webClientBuilder.baseUrl("http://" + serviceId + "/").build();
    }

    /**
     * 构建HttpClient适配器
     *
     * @param conversionService 安全的类型转换服务
     * @param webClientBuilder  构建WebClient的Builder
     * @param serviceId         注册中心的ServiceId
     * @return ReactiveHttpClientAdapter
     */
    public static ReactiveHttpClientAdapter build(ConversionService conversionService, WebClient.Builder webClientBuilder, String serviceId) {
        ReactiveHttpClientAdapter adapter = new ReactiveHttpClientAdapter(webClientBuilder, serviceId);

        adapter.typeConvert = o -> conversionService.convert(o, String.class);
        return adapter;
    }

    /**
     * 发起http请求
     *
     * @param method     {@link org.rxjava.apikit.core.HttpMethodType}
     * @param uri        请求的uri地址
     * @param form       post请求参数
     * @param returnType 返回值类型
     */
    @Override
    public <T> Mono<T> request(String method, String uri, List<Map.Entry<String, Object>> form, Type returnType) {

        ParameterizedTypeReference<T> typeRef = new ParameterizedTypeReference<T>() {
            @Override
            public Type getType() {
                return returnType;
            }
        };

        HttpMethod httpMethod = HttpMethod.valueOf(method);

        //检查是否post请求
        boolean postData = form != null
                && (httpMethod == HttpMethod.PUT ||
                httpMethod == HttpMethod.POST ||
                httpMethod == HttpMethod.PATCH ||
                httpMethod == HttpMethod.DELETE);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        if (form != null) {
            for (Map.Entry<String, Object> item : form) {
                params.add(item.getKey(), typeConvert.apply(item.getValue()));
            }
        }

        //设置post请求参数
        WebClient.RequestBodySpec bodySpec = webClient
                .method(httpMethod)
                .uri(uriBuilder -> {
                    uriBuilder = uriBuilder.path(uri);
                    if (!postData && form != null) {
                        uriBuilder = uriBuilder.queryParams(params);
                    }
                    return uriBuilder.build();
                });

        //请求头设置接收中文语言
        bodySpec.header("Accept-Language", "zh_CN");

        if (token != null) {
            bodySpec = bodySpec.header("authorization", token);
        }

        WebClient.ResponseSpec retrieve = postData ?
                bodySpec.syncBody(params).retrieve()
                : bodySpec.retrieve();

        return retrieve
                .bodyToMono(typeRef);
    }

}
