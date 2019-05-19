package org.rxjava.service.reward.entity;

import lombok.Data;
import org.rxjava.service.reward.status.RewardRecordStatus;
import org.rxjava.service.reward.type.RewardType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author happy 2019-05-15 10:53
 * 奖品事件发放记录
 */
@Document
@Data
public class RewardIssueRecord {
    @Id
    private String id;
    /**
     * 奖励事件Id
     */
    private String rewardEventId;
    /**
     * 操作人员Id
     */
    private String operatorId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 用户会员卡Id
     */
    private String userVipCardId;
    /**
     * 奖品类型：优惠券COUPON，红包REDENVELOPE，积分INTEGRAL
     *
     * @see RewardType
     */
    private String rewardType;
    /**
     * 用户奖品Id，根据记录类型判断，若是优惠券，则是用户优惠券码Id
     */
    private String userRewardId;
    /**
     * 奖品Id，根据记录类型判断，若是优惠券，则是优惠券码Id
     */
    private String rewardId;
    /**
     * 状态
     *
     * @see RewardRecordStatus
     */
    private String status = RewardRecordStatus.FAIL.name();
    /**
     * 发放失败原因
     */
    private String failReason;
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = IndexDirection.DESCENDING)
    private LocalDateTime createDate;
}
