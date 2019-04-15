package org.rxjava.service.pay.client;

import org.apache.commons.lang3.RandomStringUtils;
import org.rxjava.service.pay.form.PayNoticeCallbackForm;
import org.rxjava.service.pay.form.StartPayForm;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

/**
 * @author happy 2019-04-15 23:27
 */
@RestController
public class PayController {

    /**
     * 开始支付
     */
    @PostMapping("startPay")
    public Mono<String> startPay(
            @Valid StartPayForm form
    ) {
        return Mono.just(RandomStringUtils.random(32));
    }

    /**
     * 支付通知回调
     */
    @PostMapping("payNoticeCallback")
    public Mono<Void> payNoticeCallback(
            @Valid PayNoticeCallbackForm form
    ) {
        return Mono.empty();
    }
}
