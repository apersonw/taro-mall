package org.rxjava.service.reward.type;

/**
 * @author happy 2019-05-14 18:41
 */
public enum RewardType {
    /**
     * 红包
     */
    REDENVELOPE,
    /**
     * 积分
     */
    INTEGRAL,
    /**
     * 优惠券码
     */
    COUPON;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (RewardType rewardType : RewardType.values()) {
            if (rewardType.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
