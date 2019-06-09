package org.rxjava.service.reward.type;

/**
 * @author happy 2019-05-16 13:26
 */
public enum ValidUnitType {
    /**
     * 不限制
     */
    NOTLIMIT,
    /**
     * 年
     */
    YEAR,
    /**
     * 月
     */
    MONTH,
    /**
     * 日
     */
    DAY,
    /**
     * 小时
     */
    HOUR;

    /**
     * 判断参数合法性
     */
    public static boolean isValidName(String name) {
        for (ValidUnitType type : ValidUnitType.values()) {
            if (type.name().equals(name)) {
                return true;
            }
        }
        return false;
    }
}
