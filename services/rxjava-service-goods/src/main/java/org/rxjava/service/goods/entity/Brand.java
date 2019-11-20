package org.rxjava.service.goods.entity;

import lombok.Getter;
import lombok.Setter;
import org.rxjava.common.core.entity.BaseEntity;

/**
 * @author happy 2019-03-17 23:25
 */
@Getter
@Setter
public class Brand extends BaseEntity {
    /**
     * 品牌名称
     */
    private String name;
}
