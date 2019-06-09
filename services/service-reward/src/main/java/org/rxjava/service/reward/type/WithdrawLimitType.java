package org.rxjava.service.reward.type;

/**
 * @author happy 2019-05-16 11:49
 * 提现限制类型
 */
public enum WithdrawLimitType {
    /**
     * 可提现
     */
    WITHDRAW,
    /**
     * 不可提现
     */
    NOTWITHDRAW;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (WithdrawLimitType type : WithdrawLimitType.values()) {
            if (type.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
