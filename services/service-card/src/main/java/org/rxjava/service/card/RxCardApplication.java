package org.rxjava.service.card;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author happy 2019-03-17 22:10
 */
@SpringBootApplication
@RestController
public class RxCardApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder(RxCardApplication.class).web(WebApplicationType.REACTIVE).run(args);
    }
}
