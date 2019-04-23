package org.rxjava.common.core.entity;

import lombok.Data;

/**
 * @author happy 2019-04-22 16:59
 * 视频
 */
@Data
public class Video {
    /**
     * 标题
     */
    private String title;
    /**
     * 宽：单位像素
     */
    private int width;
    /**
     * 高：单位像素
     */
    private int height;
    /**
     * 视频Key
     */
    private String key;
}
