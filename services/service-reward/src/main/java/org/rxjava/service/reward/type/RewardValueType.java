package org.rxjava.service.reward.type;

/**
 * @author happy 2019-05-14 18:19
 * 红包类型
 */
public enum RewardValueType {
    /**
     * 固定金额
     */
    FIXED,
    /**
     * 随机金额
     */
    RANDOM;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (RewardValueType type : RewardValueType.values()) {
            if (type.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
