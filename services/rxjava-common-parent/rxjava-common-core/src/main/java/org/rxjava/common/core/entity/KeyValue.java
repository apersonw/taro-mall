package org.rxjava.common.core.entity;

import lombok.*;

import java.util.Objects;

/**
 * @author happy 2019-04-22 15:47
 * 键值对
 */
@Data
public class KeyValue<K, V> {
    private K key;
    private V value;
}
