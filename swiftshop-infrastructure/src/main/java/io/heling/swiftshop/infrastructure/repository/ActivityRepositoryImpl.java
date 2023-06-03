package io.heling.swiftshop.infrastructure.repository;

import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.domain.model.SwiftShopActivity;
import io.heling.swiftshop.domain.repository.ActivityRepository;
import io.heling.swiftshop.infrastructure.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 20:10
 * @description
 */
@Component
public class ActivityRepositoryImpl implements ActivityRepository {

    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public int saveActivity(SwiftShopActivity activity) {
        if(Objects.isNull(activity)){
            throw new SwiftShopException(HttpCode.PARAMS_INVALID);
        }
        return activityMapper.saveActivity(activity);
    }

    @Override
    public List<SwiftShopActivity> getActivityList(Integer status) {
        return activityMapper.getActivityList(status);
    }

    @Override
    public List<SwiftShopActivity> getActivityListBetweenStartTimeAndEndTime(Date currentTime, Integer status) {
        return activityMapper.getActivityListBetweenStartTimeAndEndTime(currentTime,status);
    }

    @Override
    public SwiftShopActivity getActivityById(Long id) {
        return activityMapper.getActivityById(id);
    }

    @Override
    public int updateStatus(Integer status, Long id) {
        return activityMapper.updateStatus(status,id);
    }
}
