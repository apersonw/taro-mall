package org.rxjava.common.core.annotation;

import java.lang.annotation.*;

/**
 * 登陆注解
 * 默认为必须登陆
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Login {
    boolean value() default true;
}