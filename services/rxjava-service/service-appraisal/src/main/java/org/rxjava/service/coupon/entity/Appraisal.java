package org.rxjava.service.coupon.entity;

import lombok.Data;
import org.rxjava.common.core.entity.Image;
import org.rxjava.common.core.entity.Video;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;

import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.data.mongodb.core.index.IndexDirection.DESCENDING;

/**
 * @author happy 2019-04-22 15:44
 * 评价
 */
@Data
public class Appraisal {
    @Id
    private String id;
    /**
     * 商品评价Id
     */
    private String goodsAppraisalId;
    /**
     * 商铺Id
     */
    private String shopId;
    /**
     * 商品Id
     */
    private String goodsId;
    /**
     * 订单商品Id
     */
    private String orderGoodsId;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 订单Id
     */
    private String orderId;
    /**
     * 评价内容
     */
    private String text;
    /**
     * 图片列表
     */
    private List<Image> images;
    /**
     * 视频列表
     */
    private List<Video> videos;
    /**
     * 评分
     */
    private int score = 500;
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
