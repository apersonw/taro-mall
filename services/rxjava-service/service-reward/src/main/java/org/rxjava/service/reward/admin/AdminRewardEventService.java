package org.rxjava.service.reward.admin;

import org.apache.commons.lang3.RandomUtils;
import org.rxjava.common.core.entity.LoginInfo;
import org.rxjava.common.core.exception.ErrorMessageException;
import org.rxjava.service.reward.entity.RandomRange;
import org.rxjava.service.reward.entity.Reward;
import org.rxjava.service.reward.entity.RewardEvent;
import org.rxjava.service.reward.entity.RewardIssueRecord;
import org.rxjava.service.reward.form.RewardEventSaveForm;
import org.rxjava.service.reward.repository.RewardEventRepository;
import org.rxjava.service.reward.repository.RewardIssueRecordRepository;
import org.rxjava.service.reward.repository.RewardRepository;
import org.rxjava.service.reward.repository.UserRewardRepository;
import org.rxjava.service.reward.status.RewardEventStatus;
import org.rxjava.service.reward.status.RewardStatus;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.*;

/**
 * @author happy 2019-05-15 16:46
 */
@RequestMapping("admin")
@RestController
public class AdminRewardEventService {
    @Autowired
    private RewardEventRepository rewardEventRepository;
    @Autowired
    private RewardRepository rewardRepository;
    @Autowired
    private RewardIssueRecordRepository rewardIssueRecordRepository;
    @Autowired
    private UserRewardRepository userRewardRepository;

    /**
     * 保存奖励事件
     */
    @PostMapping("rewardEvent")
    public Mono<RewardEvent> saveReward(
            @Valid RewardEventSaveForm form,
            LoginInfo loginInfo
    ) {
        return Mono.justOrEmpty(form.getId())
                .flatMap(rewardEventId -> rewardEventRepository.findById(rewardEventId))
                .switchIfEmpty(Mono.just(new RewardEvent()).map(rewardEvent -> {
                    //id由系统生成
                    form.setId(null);
                    return rewardEvent;
                }))
                .map(rewardEvent -> {
                    BeanUtils.copyProperties(form, rewardEvent);
                    rewardEvent.setOperatorId(loginInfo.getUserId());
                    return rewardEvent;
                })
                .flatMap(rewardEventRepository::save);
    }

    /**
     * 执行发放奖励事件
     */
    @PatchMapping("rewardEvent/{rewardEventId}/execute")
    public Mono<Void> executeRewardEvent(
            @PathVariable String rewardEventId,
            LoginInfo loginInfo
    ) {
        return rewardEventRepository
                .findById(rewardEventId)
                .map(rewardEvent -> {
                    //检查事件状态
                    if (RewardEventStatus.CLOSED.name().equals(rewardEvent.getStatus())) {
                        throw ErrorMessageException.of("eventIsClosed");
                    }
                    //检查事件是否在可触发时间范围
                    LocalDateTime now = LocalDateTime.now();
                    if (now.isBefore(rewardEvent.getAvailableBeginDate()) || now.isAfter(rewardEvent.getAvailableEndDate())) {
                        throw ErrorMessageException.of("notInAvailableDate");
                    }
                    return rewardEvent;
                })
                .then();
    }

    /**
     * 获取奖品随机值
     */
    public int getRandomValue(Reward reward) {
        float robability = RandomUtils.nextFloat();
        List<RandomRange> randomRanges = reward.getRandomRanges();
        randomRanges.sort(Comparator.comparing(RandomRange::getPercentage));

        List<Float> robabilities = new ArrayList<>();

        randomRanges.forEach(randomRange -> robabilities.add(randomRange.getRobability()));

        robabilities.add(robability);

        Collections.sort(robabilities);
        int index = robabilities.indexOf(robability);
        RandomRange randomRange = randomRanges.get(index - 1);
        return RandomUtils.nextInt(randomRange.getMinValue(), randomRange.getMaxValue());
    }

    public static void main(String[] args) {
        float robability = RandomUtils.nextFloat(0, 1);
        List<Float> robabilities = new ArrayList<>(Arrays.asList(0.3390465974807739f, 0.08837707340717316f, 0.911622941493988f));
        System.out.println(robability);
        System.out.println(robabilities);
        robabilities.add(robability);
        Collections.sort(robabilities);
        int i = robabilities.indexOf(robability);
        System.out.println(i);
        System.out.println(robabilities);
    }

    /**
     * 查询奖励事件分页
     */
    @GetMapping("rewardEventPage/{page}-{pageSize}")
    public Mono<Page<RewardEvent>> findPage(
            @PathVariable int page,
            @PathVariable int pageSize
    ) {
        return rewardEventRepository
                .findPage(PageRequest.of(page, pageSize));
    }

    /**
     * 查询奖励事件记录分页
     */
    @GetMapping("rewardIssueRecordPage/{page}-{pageSize}")
    public Mono<Page<RewardIssueRecord>> findRewardIssueRecordPage(
            @PathVariable int page,
            @PathVariable int pageSize
    ) {
        return rewardIssueRecordRepository
                .findPage(PageRequest.of(page, pageSize));
    }

    /**
     * 关闭奖励事件
     */
    @PatchMapping("rewardEvent/{rewardEventId}/status/closed")
    public Mono<Void> closedRewardStatus(
            @PathVariable String rewardEventId
    ) {
        return rewardEventRepository
                .patchStatusById(rewardEventId, RewardStatus.NORMAL.name(), RewardStatus.CLOSED.name());
    }
}
