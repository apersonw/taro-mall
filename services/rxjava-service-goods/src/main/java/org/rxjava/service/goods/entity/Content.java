package org.rxjava.service.goods.entity;

import javafx.scene.image.Image;
import lombok.Getter;
import lombok.Setter;

/**
 * @author happy 2019-03-27 21:17
 */
@Getter
@Setter
public class Content {
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 优先级
     */
    private int priority;
    /**
     * 类型：IMG,TEXT,VIDEO,FILE
     */
    private String type;
    private Image image;
    private String value;
}
