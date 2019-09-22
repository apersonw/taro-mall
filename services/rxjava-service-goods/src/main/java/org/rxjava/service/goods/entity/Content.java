package org.rxjava.service.goods.entity;

import javafx.scene.image.Image;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-27 21:17
 */
@Data
@Document
public class Content {
    @Id
    private String id;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 优先级
     */
    private int priority;
    /**
     * 类型：IMG,TEXT,VIDEO,FILE
     */
    private String type;
    private Image image;
    private String value;
    /**
     * 创建日期
     */
    @CreatedDate
    @Indexed(direction = DESCENDING)
    private LocalDateTime createDate;
    /**
     * 更新日期
     */
    @LastModifiedDate
    private LocalDateTime updateDate;
}
