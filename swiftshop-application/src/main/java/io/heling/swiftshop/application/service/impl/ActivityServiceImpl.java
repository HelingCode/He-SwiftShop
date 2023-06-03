package io.heling.swiftshop.application.service.impl;

import io.heling.swiftshop.application.service.ActivityService;
import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.dto.ActivityDTO;
import io.heling.swiftshop.domain.enums.ActivityStatus;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.domain.model.SwiftShopActivity;
import io.heling.swiftshop.domain.repository.ActivityRepository;
import io.heling.swiftshop.infrastructure.utils.beans.BeanUtil;
import io.heling.swiftshop.infrastructure.utils.id.SnowFlakeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 22:43
 * @description
 */
@Service
public class ActivityServiceImpl implements ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void saveActivityDTO(ActivityDTO activityDTO) {
        if(Objects.isNull(activityDTO)) {
            throw new SwiftShopException(HttpCode.PARAMS_INVALID);
        }
        SwiftShopActivity swiftShopActivity = new SwiftShopActivity();
        BeanUtil.copyProperties(activityDTO,swiftShopActivity);
        swiftShopActivity.setId(SnowFlakeFactory.getSnowFlakeFromCache().nextId());
        swiftShopActivity.setStatus(ActivityStatus.PUBLISHED.getCode());
        activityRepository.saveActivity(swiftShopActivity);

    }

    @Override
    public List<SwiftShopActivity> getActivityList(Integer status) {
        return activityRepository.getActivityList(status);
    }

    @Override
    public List<SwiftShopActivity> getActivityListBetweenStartTimeAndEndTime(Date currentTime, Integer status) {
        return activityRepository.getActivityListBetweenStartTimeAndEndTime(currentTime,status);
    }

    @Override
    public SwiftShopActivity getActivityById(Long id) {
        return activityRepository.getActivityById(id);
    }

    @Override
    public int updateStatus(Integer status, Long id) {
        return activityRepository.updateStatus(status,id);
    }
}
