package io.heling.swiftshop.interfaces.controller;

import io.heling.swiftshop.application.service.GoodsService;
import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.dto.GoodsDTO;
import io.heling.swiftshop.domain.model.SwiftShopGoods;
import io.heling.swiftshop.domain.response.ResponseMessage;
import io.heling.swiftshop.domain.response.ResponseMessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/4 16:19
 * @description
 */
@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * 保存秒杀商品
     */
    @RequestMapping(value = "/saveSeckillGoods", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<String> saveSeckillActivityDTO(GoodsDTO seckillGoodsDTO){
        goodsService.saveGoods(seckillGoodsDTO);
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),HttpCode.SUCCESS.getMesaage());
    }

    /**
     * 获取商品详情
     */
    @RequestMapping(value = "/getSeckillGoodsId", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<SwiftShopGoods> getSeckillGoodsId(Long id){
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(), goodsService.getGoodsById(id));
    }

    /**
     * 获取商品列表
     */
    @RequestMapping(value = "/getSeckillGoodsByActivityId", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<List<SwiftShopGoods>> getSeckillGoodsByActivityId(Long activityId){
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(), goodsService.getGoodsByActivityId(activityId));
    }

    /**
     * 更新商品状态
     */
    @RequestMapping(value = "/updateStatus", method = {RequestMethod.GET,RequestMethod.POST})
    public ResponseMessage<String> updateStatus(Integer status, Long id){
        goodsService.updateStatus(status, id);
        return ResponseMessageBuilder.build(HttpCode.SUCCESS.getCode(),HttpCode.SUCCESS.getMesaage());
    }
}
