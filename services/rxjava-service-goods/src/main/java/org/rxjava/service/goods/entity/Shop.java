package org.rxjava.service.goods.entity;

import lombok.Getter;
import lombok.Setter;
import org.rxjava.common.core.entity.BaseEntity;

/**
 * @author happy 2019-03-17 23:23
 */
@Getter
@Setter
public class Shop extends BaseEntity {
    /**
     * 商铺名称
     */
    private String name;
}
