package org.rxjava.service.reward.person;

import org.rxjava.service.reward.repository.RewardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author happy 2019-05-14 16:37
 * 奖品服务
 */
@RestController
public class RewardService {
    @Autowired
    private RewardRepository rewardRepository;

}
