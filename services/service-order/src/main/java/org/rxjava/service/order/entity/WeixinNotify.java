package org.rxjava.service.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author happy 2019-05-19 22:18
 * 微信通知
 */
@Data
@Document
public class WeixinNotify {
    /**
     * id
     */
    @Id
    private String id;

    /**
     * 返回状态码
     */
    private String return_code;

    /**
     * 返回信息
     */
    private String return_msg;

    /**
     * 商户号
     */
    private String appid;

    /**
     * 公众账号ID
     */
    private String mch_id;

    /**
     * 设备号
     */
    private String device_info;

    /**
     * 随机字符串
     */
    private String nonce_str;

    /**
     * 签名
     */
    private String sign;

    /**
     * 业务结果
     */
    private String result_code;

    /**
     * 错误代码
     */
    private String err_code;

    /**
     * 错误代码描述
     */
    private String err_code_des;

    /**
     * 用户标识
     */
    private String openid;

    /**
     * 是否关注公众账号
     */
    private String is_subscribe;

    /**
     * 交易类型
     */
    private String trade_type;

    /**
     * 付款银行
     */
    private String bank_type;

    /**
     * 总金额
     */
    private Integer total_fee;

    /**
     * 货币种类
     */
    private String fee_type;

    /**
     * 现金支付金额
     */
    private Integer cash_fee;

    /**
     * 现金支付货币类型
     */
    private String cash_fee_type;

    /**
     * 代金券或立减优惠金额
     */
    private Integer coupon_fee;

    /**
     * 代金券或立减优惠使用数量
     */
    private Integer coupon_count;

    /**
     * 微信支付订单号
     */
    private String transaction_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 商家数据包
     */
    private String attach;

    /**
     * 支付完成时间
     */
    private String time_end;
}
