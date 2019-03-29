package org.rxjava.service.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author happy 2019-03-29 13:45
 */
@Data
@Document
public class Order {
    @Id
    private String id;
}
