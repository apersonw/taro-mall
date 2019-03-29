package org.rxjava.service.pay.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author happy 2019-03-29 13:46
 */
@Data
@Document
public class Pay {
    @Id
    private String id;
    /**
     * 订单Id
     */
    private String orderId;

}
