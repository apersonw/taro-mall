package org.rxjava.service.reward.entity;

import lombok.Data;
import org.rxjava.service.reward.status.RewardEventStatus;
import org.rxjava.service.reward.type.RewardEventType;
import org.rxjava.service.reward.type.RewardType;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author happy 2019-05-14 16:39
 * 奖励事件
 */
@Document
@Data
public class RewardEvent {
    @Id
    private String id;
    /**
     * 奖励名称
     */
    private String name;
    /**
     * 客户Id
     */
    private String partnerId;
    /**
     * 操作员Id
     */
    private String operatorId;
    /**
     * 会员卡Id
     */
    private String vipCardId;
    /**
     * 单人领取次数限制
     */
    private int personNumLimit;
    /**
     * 单人领取金额/张数/积分数
     */
    private int personValueLimit;
    /**
     * 总领取次数限制
     */
    private int totalNumLimit;
    /**
     * 总领取金额/张数/积分数
     */
    private int totalValueLimit;
    /**
     * 奖品类型：红包/积分/优惠券
     *
     * @see RewardType
     */
    private String rewardType;
    /**
     * 奖品Id列表：红包Id/积分Id/优惠券Id
     */
    private List<String> rewardIds;
    /**
     * 可发放开始日期
     */
    private LocalDateTime availableBeginDate;
    /**
     * 可发放结束日期
     */
    private LocalDateTime availableEndDate;
    /**
     * 事件类型:系统SYSTEM/手动MANUAL/外部
     *
     * @see RewardEventType
     */
    private String eventType;
    /**
     * 奖励状态:正常NORMAL,关闭CLOSED
     */
    private String status = RewardEventStatus.NORMAL.name();
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
