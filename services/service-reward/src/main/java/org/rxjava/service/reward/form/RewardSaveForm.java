package org.rxjava.service.reward.form;

import lombok.Data;
import org.rxjava.common.core.annotation.EnumValue;
import org.rxjava.service.reward.entity.RandomRange;
import org.rxjava.service.reward.type.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author happy 2019-05-15 11:34
 * 奖品保存表单
 */
@Data
public class RewardSaveForm {
    private String id;
    /**
     * 名称
     */
    @NotEmpty
    private String name;
    /**
     * 金额或积分数（随机则为上限值）
     */
    @Min(1)
    private int value;
    /**
     * 价值类型：指定或随机
     */
    @NotEmpty
    @EnumValue(enumClass = RewardValueType.class)
    private String valueType;
    /**
     * 奖品类型
     */
    @NotEmpty
    @EnumValue(enumClass = RewardType.class)
    private String type;
    /**
     * 提现限制
     */
    @NotEmpty
    @EnumValue(enumClass = WithdrawLimitType.class)
    private String withdrawLimit;
    /**
     * 使用限制
     */
    @NotEmpty
    @EnumValue(enumClass = UseLimitType.class)
    private String useLimit;
    /**
     * 价值类型为随机时则为必填值
     */
    @Size(max = 100, message = "最大仅允许100个随机范围")
    private List<RandomRange> randomRanges;
    /**
     * 有效期单位
     *
     * @see ValidUnitType
     */
    @EnumValue(enumClass = ValidUnitType.class)
    private String validUnitType = ValidUnitType.NOTLIMIT.name();
    /**
     * 有效期值
     */
    private int validValue;

}
