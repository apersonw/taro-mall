package org.rxjava.service.mall.entity;

import lombok.Data;

/**
 * @author happy 2019-03-21 00:29
 */
@Data
public class Image {
    /**
     * 标题
     */
    private String title;
    /**
     * 备注
     */
    private String remark;
    /**
     * 宽：单位像素
     */
    private int width;
    /**
     * 高：单位像素
     */
    private int height;
    /**
     * 图片Key
     */
    private String key;
    /**
     * 点击图片链接地址
     */
    private String link;
}
