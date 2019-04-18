package org.rxjava.service.goods.entity;

import lombok.Data;
import org.rxjava.common.core.entity.Image;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-03-27 21:46
 */
@Data
@Document
public class CarouselImg {
    @Id
    private String id;
    private String goodsId;
    private Image carouselImg;
    /**
     * 优先级
     */
    private int priority;
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
