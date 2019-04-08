package org.rxjava.service.center;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@EnableEurekaServer
public class RxCenterApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxCenterApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}