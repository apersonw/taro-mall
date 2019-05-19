package org.rxjava.service.reward.entity;

import lombok.Data;
import org.rxjava.service.reward.status.RewardStatus;
import org.rxjava.service.reward.type.RewardValueType;
import org.rxjava.service.reward.type.UseLimitType;
import org.rxjava.service.reward.type.ValidUnitType;
import org.rxjava.service.reward.type.WithdrawLimitType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author happy 2019-05-14 18:39
 * 奖品(积分或红包)
 */
@Document
@Data
public class Reward {
    @Id
    private String id;
    /**
     * 名称
     */
    private String name;
    /**
     * 金额或积分数（随机则为上限值）(金额单位：分，积分单位：积分)
     */
    private int value;
    /**
     * 价值类型：指定或随机
     * @see RewardValueType
     */
    private String valueType;
    /**
     * 奖品类型
     */
    private String type;
    /**
     * 使用限制
     * @see UseLimitType
     */
    private String useLimit;
    /**
     * 提现限制
     * @see WithdrawLimitType
     */
    private String withdrawLimit;
    /**
     * 有效期单位
     * @see ValidUnitType
     */
    private String validUnitType;
    /**
     * 有效期值
     */
    private int validValue;
    /**
     * 随机值范围
     */
    private List<RandomRange> randomRanges;
    /**
     * 奖品状态：正常NORMAL，关闭CLOSED
     */
    private String status = RewardStatus.NORMAL.name();
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = IndexDirection.DESCENDING)
    private LocalDateTime createDate;
    /**
     * 修改日期
     */
    @LastModifiedDate
    private LocalDateTime updateDate;
}
