package org.rxjava.service.pay.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @author happy 2019-04-15 23:37
 */
@Data
public class PayNoticeCallbackForm {
    /**
     * 支付Id
     */
    @NotEmpty(message = "支付Id不能为空")
    private String payId;
}
