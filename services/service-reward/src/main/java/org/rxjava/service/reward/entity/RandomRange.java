package org.rxjava.service.reward.entity;

import lombok.Data;

/**
 * @author happy 2019-05-14 18:23
 * 随机范围
 */
@Data
public class RandomRange {
    /**
     * 最小值
     */
    private int minValue;
    /**
     * 最大值
     */
    private int maxValue;
    /**
     * 百分比
     */
    private float percentage;
    /**
     * 概率区间
     */
    private float robability;
}
