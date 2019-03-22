package org.rxjava.service.mall.entity;

import io.lettuce.core.KeyValue;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * @author happy 2019-03-17 23:22
 */
@Data
@Document
public class Category {
    /**
     * ID
     */
    @Id
    private String id;
}
