package io.heling.swiftshop.interfaces.controller;

import io.heling.swiftshop.application.service.ActivityService;
import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.dto.ActivityDTO;
import io.heling.swiftshop.domain.model.SwiftShopActivity;
import io.heling.swiftshop.domain.response.ResponseMessage;
import io.heling.swiftshop.domain.response.ResponseMessageBuilder;
import io.heling.swiftshop.infrastructure.utils.date.JodaDateTimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/2 22:58
 * @description
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    /**
     * 保存秒杀活动
     * @param activityDTO
     * @return
     */
    @RequestMapping(value = "/saveActivity",method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<String> saveActivityDTO(@RequestBody ActivityDTO activityDTO) {
        activityService.saveActivityDTO(activityDTO);
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),HttpCode.SUCCESS.getMesaage());
    }

    /**
     * 根据状态获取活动列表
     * @param status
     * @return
     */
    @RequestMapping(value = "/getActivityList",method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<List<SwiftShopActivity>> getActivityList(@RequestParam(value = "status",required = false) Integer status) {
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),activityService.getActivityList(status));
    }

    /**
     * 根据时间和状态获取活动列表
     */
    @RequestMapping(value = "/getActivityListBetweenStartTimeAndEndTime", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<List<SwiftShopActivity>> getActivityListBetweenStartTimeAndEndTime(@RequestParam(value = "currentTime", required = false) String currentTime,
                                                                                                   @RequestParam(value = "status", required = false)Integer status){
        List<SwiftShopActivity> activityList = activityService.getActivityListBetweenStartTimeAndEndTime(JodaDateTimeUtils.parseStringToDate(currentTime, JodaDateTimeUtils.DATE_TIME_FORMAT), status);
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(), activityList);
    }

    /**
     * 获取id获取秒杀活动详情
     */
    @RequestMapping(value = "/getActivityById", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<SwiftShopActivity> getActivityById(@RequestParam(value = "id", required = false) Long id){
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(), activityService.getActivityById(id));
    }

    /**
     * 更新活动的状态
     */
    @RequestMapping(value = "/updateStatus", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<String> updateStatus(@RequestParam(value = "status", required = false) Integer status,
                                                @RequestParam(value = "id", required = false) Long id){
        activityService.updateStatus(status, id);
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),HttpCode.SUCCESS.getMesaage());
    }
}
