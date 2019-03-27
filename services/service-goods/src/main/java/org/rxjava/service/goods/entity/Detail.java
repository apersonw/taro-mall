package org.rxjava.service.goods.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;

/**
 * @author happy 2019-03-27 20:56
 * 商品详情
 */
@Data
public class Detail {
    @Id
    private String id;
    private List<Image> carouselImgs;
    private List<Content> contents;
}
