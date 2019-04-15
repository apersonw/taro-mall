package org.rxjava.service.pay.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-04-15 23:29
 */
@Data
public class StartPayForm {
    /**
     * 订单Id
     */
    @NotEmpty(message = "订单Id不能为空")
    private String orderId;
    /**
     * 用户Id
     */
    @NotEmpty(message = "用户Id不能为空")
    private String userId;
}
