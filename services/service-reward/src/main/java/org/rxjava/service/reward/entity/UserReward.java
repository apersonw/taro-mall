package org.rxjava.service.reward.entity;

import lombok.Data;
import org.rxjava.service.reward.type.RewardType;
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

/**
 * @author happy 2019-05-14 18:39
 * 用户的奖品(积分或红包)
 */
@Document
@Data
public class UserReward {
    @Id
    private String id;
    /**
     * 奖品Id
     */
    private String rewardId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 名称
     */
    private String name;
    /**
     * 金额或积分数
     */
    private int value;
    /**
     * 奖品类型
     *
     * @see RewardType
     */
    private String type;
    /**
     * 使用限制
     * @see UseLimitType
     */
    private String useLimit;
    /**
     * 提现限制(积分不可提现)
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
