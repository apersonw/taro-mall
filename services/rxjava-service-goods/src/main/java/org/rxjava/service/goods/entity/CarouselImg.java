package org.rxjava.service.goods.entity;

import lombok.Getter;
import lombok.Setter;
import org.rxjava.common.core.entity.BaseEntity;
import org.rxjava.common.core.entity.Image;

/**
 * @author happy 2019-03-27 21:46
 */
@Getter
@Setter
public class CarouselImg extends BaseEntity {
    private String goodsId;
    private Image carouselImg;
    /**
     * 优先级
     */
    private int priority;
}
