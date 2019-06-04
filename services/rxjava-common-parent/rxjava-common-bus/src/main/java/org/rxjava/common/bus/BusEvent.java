package org.rxjava.common.bus;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.Data;

/**
 * @author happy 2019-06-04 10:26
 */
@Data
public class BusEvent {
    /**
     * 事件唯一Id，保证幂等
     */
    private String id;
    /**
     * 事件类型
     */
    private BusEventType type;
    /**
     * 时间戳
     */
    private long timestamp;
    /**
     * 微服务
     */
    private String service;
    /**
     * 数据
     */
    private JsonNode data;
}
