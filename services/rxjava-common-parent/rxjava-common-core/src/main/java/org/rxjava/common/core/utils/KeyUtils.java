package org.rxjava.common.core.utils;

/**
 * @author happy 2019-04-27 00:30
 */
public class KeyUtils {
    public static String newCacheId(Class clazz, String key) {
        return clazz.getSimpleName() + "-" + key;
    }
}
