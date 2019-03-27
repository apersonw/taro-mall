package org.rxjava.service.goods.entity;

import lombok.Data;

/**
 * @author happy 2019-03-27 21:17
 */
@Data
public class Content {
    /**
     * 类型：IMG,TEXT,VIDEO,FILE
     */
    private String type;
    private Image image;
    private String value;
}
