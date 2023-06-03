package io.heling.swiftshop.infrastructure.mapper;

import io.heling.swiftshop.domain.model.SwiftShopActivity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 20:00
 * @description
 */
public interface ActivityMapper {

    /**
     * 保存活动信息
     *
     * @param activity
     * @return
     */
    int saveActivity(SwiftShopActivity activity);

    /**
     * 根据状态获取活动列表
     *
     * @param status
     * @return
     */
    List<SwiftShopActivity> getActivityList(@Param("status") Integer status);

    /**
     * 根据时间和状态获取活动列表
     *
     * @param currentTime
     * @param status
     * @return
     */
    List<SwiftShopActivity> getActivityListBetweenStartTimeAndEndTime(@Param("currentTime") Date currentTime, @Param("status") Integer status);

    /**
     * 根据id获取活动信息
     *
     * @param id
     * @return
     */
    SwiftShopActivity getActivityById(@Param("id") Long id);

    /**
     * 更新活动状态
     *
     * @param status
     * @param id
     * @return
     */
    int updateStatus(@Param("status") Integer status, @Param("id") Long id);
}
