package org.rxjava.service.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author happy 2019-05-19 22:13
 */
@Data
@Document
public class AlipayOrder {
    /**
     * ID
     */
    @Id
    private String id;
    /**
     * 商户订单号,	商户系统内部的订单号,32个字符内、可包含字母, 其他说明见商户订单号
     */
    @Indexed(unique = true)
    private String outTradeNo;
    /**
     * 订单order_id
     */
    @Indexed
    private String orderId;
    /**
     * 用户id
     */
    @Indexed
    private String userId;
    /**
     * 通知次数
     */
    private int notifyCount;
    /**
     * 最后一次通知时间
     */
    private LocalDateTime lastNotifyTime;
    /**
     * 商品描述,商品或支付单简要描述
     */
    private String body;
    /**
     * 货币类型,CNY 	符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String feeType = "CNY";
    /**
     * 订单总金额，单位为分，详见支付金额
     */
    private int totalFee;
    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String timeStart;
    /**
     * 交易结束时间, 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则注意：最短失效时间间隔必须大于5分钟
     */
    private String timeExpire;
    /**
     * 阿里云AppId
     */
    private String appId;
    /**
     * 交易类型, JSAPI 	取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
     */
    private String tradeType;
}
