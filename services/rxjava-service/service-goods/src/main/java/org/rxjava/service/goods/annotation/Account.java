package org.rxjava.service.goods.annotation;

import java.lang.annotation.*;

/**
 * 是否登陆注解
 * 默认为登陆
 *
 * @author happy 2019-03-17 22:21
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Account {
    boolean value() default true;
}
