package org.rxjava.service.reward.form;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import org.rxjava.common.core.annotation.EnumValue;
import org.rxjava.service.reward.type.RewardEventType;
import org.rxjava.service.reward.type.RewardType;

import javax.validation.constraints.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author happy 2019-05-15 16:50
 * 奖励事件保存表单
 */
@Data
public class RewardEventSaveForm {
    private String id;
    /**
     * 奖励名称
     */
    @NotEmpty
    private String name;
    /**
     * 客户Id
     */
    @NotEmpty
    private String partnerId;
    /**
     * 会员卡Id
     */
    @NotEmpty
    private String vipCardId;
    /**
     * 单人发放次数限制
     */
    @Range(min = 1, max = 1000)
    private int personNumLimit;
    /**
     * 单人发放金额/张数/积分数限制
     */
    @Min(1)
    private int personValueLimit;
    /**
     * 总领取次数限制
     */
    @Min(1)
    private int totalNumLimit;
    /**
     * 总领取金额/张数/积分数
     */
    @Min(1)
    private int totalValueLimit;
    /**
     * 奖品类型：红包/积分/优惠券
     */
    @EnumValue(enumClass = RewardType.class)
    @NotEmpty
    private String rewardType;
    /**
     * 奖品Id列表：红包Id/积分Id/优惠券Id
     */
    @Size(min = 1)
    @NotEmpty
    private List<String> rewardIds;
    /**
     * 可发放开始日期
     */
    @NotNull
    private LocalDateTime availableBeginDate;
    /**
     * 可发放结束日期
     */
    @Future
    @NotNull
    private LocalDateTime availableEndDate;
    /**
     * 事件类型:系统SYSTEM/手动MANUAL
     */
    @EnumValue(enumClass = RewardEventType.class)
    @NotEmpty
    private String eventType;
}
