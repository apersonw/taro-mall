package org.rxjava.common.core.entity;

import lombok.Data;

/**
 * @author happy 2019-03-21 00:29
 * 资源
 */
@Data
public class Resource {
    /**
     * 宽：单位像素
     */
    private int width;
    /**
     * 高：单位像素
     */
    private int height;
    /**
     * 资源Key
     */
    private String key;
}
