package org.rxjava.service.reward.type;

/**
 * @author happy 2019-05-14 18:29
 * 使用限制
 */
public enum UseLimitType {
    /**
     * 无限制
     */
    NOLIMIT;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (UseLimitType type : UseLimitType.values()) {
            if (type.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
