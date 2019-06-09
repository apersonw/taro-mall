package org.rxjava.service.reward.type;

/**
 * @author happy 2019-05-14 17:15
 * 奖励事件类型
 */
public enum RewardEventType {
    /**
     * 系统事件
     */
    SYSTEM,
    /**
     * 手动事件
     */
    MANUAL,
    /**
     * 接口事件
     */
    INTERFACE;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (RewardEventType rewardEventType : RewardEventType.values()) {
            if (rewardEventType.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
