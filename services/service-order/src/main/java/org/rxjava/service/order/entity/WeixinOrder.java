package org.rxjava.service.order.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author happy 2019-05-19 22:12
 */
@Data
@Document
public class WeixinOrder {
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
     * 公众账号ID
     */
    @Indexed
    private String appid;
    /**
     * 微信支付分配的商户号
     */
    @Indexed
    private String mchId;
    /**
     * 通知次数
     */
    private int notifyCount;
    /**
     * 最后一次通知时间
     */
    private LocalDateTime lastNotifyTime;
    /**
     * 终端设备号(门店号或收银设备ID)，注意：PC网页或公众号内支付请传"WEB"
     */
    private String deviceInfo;
    /**
     * 5K8264ILTKCH16CQ2502SI8ZNMTM67VS 	随机字符串，不长于32位。推荐随机数生成算法
     */
    private String nonceStr;
    /**
     * 签名,详见签名生成算法
     */
    private String sign;
    /**
     * 商品描述,商品或支付单简要描述
     */
    private String body;
    /**
     * 深圳分店 	附加数据，在查询API和支付通知中原样返回，该字段主要用于商户携带订单的自定义数据
     */
    private String attach;
    /**
     * 货币类型,CNY 	符合ISO 4217标准的三位字母代码，默认人民币：CNY，其他值列表详见货币类型
     */
    private String feeType;
    /**
     * 订单总金额，单位为分，详见支付金额
     */
    private int totalFee;
    /**
     * 终端IP,APP和网页支付提交用户端ip，Native支付填调用微信支付API的机器IP。
     */
    private String spbillCreateIp;
    /**
     * 订单生成时间，格式为yyyyMMddHHmmss，如2009年12月25日9点10分10秒表示为20091225091010。其他详见时间规则
     */
    private String timeStart;
    /**
     * 交易结束时间, 订单失效时间，格式为yyyyMMddHHmmss，如2009年12月27日9点10分10秒表示为20091227091010。其他详见时间规则注意：最短失效时间间隔必须大于5分钟
     */
    private String timeExpire;
    /**
     * WXG 	商品标记，代金券或立减优惠功能的参数，说明详见代金券或立减优惠
     */
    private String goodsTag;
    /**
     * 交易类型, JSAPI 	取值如下：JSAPI，NATIVE，APP，详细说明见参数规定
     */
    private String tradeType;
    /**
     * 商品ID, trade_type=NATIVE，此参数必传。此id为二维码中包含的商品ID，商户自行定义。
     */
    private String productId;
    /**
     * 指定支付方式,no_credit 	no_credit--指定不能使用信用卡支付
     */
    private String limitPay;
    /**
     * oUpF8uMuAJO_M2pxb1Q9zNjWeS6o 	trade_type=JSAPI，此参数必传，用户在商户appid下的唯一标识。openid如何获取，可参考【获取openid】。企业号请使用【企业号OAuth2.0接口】获取企业号内成员userid，再调用【企业号userid转openid接口】进行转换
     */
    private String openid;
}
