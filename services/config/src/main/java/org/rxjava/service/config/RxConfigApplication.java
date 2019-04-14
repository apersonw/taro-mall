package org.rxjava.service.config;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author happy 2019-03-17 22:10
 */
@EnableConfigServer
@SpringBootApplication
public class RxConfigApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxConfigApplication.class).web(WebApplicationType.SERVLET).run(args);
    }
}