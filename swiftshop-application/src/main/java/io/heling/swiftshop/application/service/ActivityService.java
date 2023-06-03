package io.heling.swiftshop.application.service;

import io.heling.swiftshop.domain.dto.ActivityDTO;
import io.heling.swiftshop.domain.model.SwiftShopActivity;

import java.util.Date;
import java.util.List;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 22:41
 * @description
 */
public interface ActivityService {

    /**
     * 保存活动信息
     * @param activityDTO
     * @return
     */
    void saveActivityDTO(ActivityDTO activityDTO);

    /**
     * 根据状态获取活动列表
     * @param status
     * @return
     */
    List<SwiftShopActivity> getActivityList(Integer status);

    /**
     * 根据时间和状态获取活动列表
     * @param currentTime
     * @param status
     * @return
     */
    List<SwiftShopActivity> getActivityListBetweenStartTimeAndEndTime(Date currentTime, Integer status);

    /**
     * 根据id获取活动信息
     * @param id
     * @return
     */
    SwiftShopActivity getActivityById(Long id);

    /**
     * 更新活动状态
     * @param status
     * @param id
     * @return
     */
    int updateStatus(Integer status,Long id);
}
