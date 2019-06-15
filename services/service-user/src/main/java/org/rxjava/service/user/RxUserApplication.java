package org.rxjava.service.user;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
public class RxUserApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxUserApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}