package org.rxjava.service.reward.admin;

import org.apache.commons.collections4.CollectionUtils;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.service.reward.entity.RandomRange;
import org.rxjava.service.reward.entity.Reward;
import org.rxjava.service.reward.form.RewardSaveForm;
import org.rxjava.service.reward.repository.RewardRepository;
import org.rxjava.service.reward.status.RewardStatus;
import org.rxjava.service.reward.type.RewardType;
import org.rxjava.service.reward.type.RewardValueType;
import org.rxjava.service.reward.type.WithdrawLimitType;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.util.List;

/**
 * @author happy 2019-05-14 16:37
 * 奖品管理服务
 */
@RestController
@RequestMapping("admin")
public class AdminRewardService {
    @Autowired
    private RewardRepository rewardRepository;

    /**
     * 保存奖品
     */
    @PostMapping("reward")
    public Mono<Reward> saveReward(
            @Valid RewardSaveForm form
    ) {
        String valueType = form.getValueType();
        if (RewardValueType.RANDOM.name().equals(valueType)) {
            //检查随机值空的情况
            List<RandomRange> randomRanges = form.getRandomRanges();
            if (CollectionUtils.isEmpty(randomRanges)) {
                throw ErrorMessageException.of("randomRangNotEmpty");
            }
            //检查随机值为负的情况
            randomRanges.forEach(r -> {
                if (r.getMaxValue() <= 0 || r.getMinValue() <= 0 || r.getPercentage() <= 0) {
                    throw ErrorMessageException.of("randomRangValueGreaterThanZero");
                }
                if (r.getMinValue() > r.getMaxValue()) {
                    throw ErrorMessageException.of("minValueNotGreateThanMaxValue");
                }
            });
        }
        //如果奖品类型是积分，则设置提现为不可提现
        if (RewardType.INTEGRAL.name().equals(form.getType())) {
            form.setWithdrawLimit(WithdrawLimitType.NOTWITHDRAW.name());
        }
        return Mono.justOrEmpty(form.getId())
                .flatMap(rewardId -> rewardRepository.findById(rewardId))
                .switchIfEmpty(Mono.just(new Reward()).map(r -> {
                    //id由系统生成
                    form.setId(null);
                    return r;
                }))
                .map(reward -> {
                    BeanUtils.copyProperties(form, reward);
                    //计算奖品的概率区间
                    if (RewardValueType.RANDOM.name().equals(reward.getValueType())) {
                        float sum = 0;
                        for (RandomRange randomRange : reward.getRandomRanges()) {
                            sum = randomRange.getPercentage() + sum;
                        }

                        float temp = 0;
                        for (RandomRange randomRange : reward.getRandomRanges()) {
                            temp = temp + randomRange.getPercentage();
                            randomRange.setRobability(temp / sum);
                        }
                    }
                    return reward;
                })
                .flatMap(rewardRepository::save);
    }

    /**
     * 查询奖品分页
     */
    @GetMapping("rewardPage/{page}-{pageSize}")
    public Mono<Page<Reward>> findPage(
            @PathVariable int page,
            @PathVariable int pageSize
    ) {
        return rewardRepository
                .findPage(PageRequest.of(page, pageSize));
    }

    /**
     * 关闭奖品状态
     */
    @PatchMapping("reward/{rewardId}/status/closed")
    public Mono<Void> closedRewardStatus(
            @PathVariable String rewardId
    ) {
        return rewardRepository
                .patchStatusById(rewardId, RewardStatus.NORMAL.name(), RewardStatus.CLOSED.name());
    }

}
