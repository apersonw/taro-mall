package org.rxjava.common.bus;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author happy 2019-06-04 10:22
 * 开启Bus
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({RxBusConfiguration.class})
public @interface EnableBus {
}
