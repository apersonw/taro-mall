package org.rxjava.gateway.person.controller;

import org.rxjava.common.core.annotation.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 * @author happy 2019-04-06 07:26
 */
@RestController
public class ProxyController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Login(false)
    @GetMapping("test")
    public Mono<String> getClient() {
        System.out.println("service:" + discoveryClient.getServices());
        return Mono.just(discoveryClient.getServices().toString());
    }
}
