package io.heling.swiftshop.domain.repository;

import io.heling.swiftshop.domain.model.SwiftShopGoods;

import java.util.List;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/4 15:52
 * @description
 */
public interface GoodsRepostory {

    /**
     * 保存商品信息
     */
    int saveGoods(SwiftShopGoods swiftShopGoods);

    /**
     * 根据id获取商品详情
     */
    SwiftShopGoods getGoodsById(Long id);

    /**
     * 根据活动id获取商品列表
     */
    List<SwiftShopGoods> getGoodsByActivityId(Long activityId);

    /**
     * 修改商品状态
     */
    int updateStatus(Integer status,Long id);

    /**
     * 扣减库存
     */
    int updateAvailableStock(Integer count, Long id);

    /**
     * 获取当前可用库存
     */
    Integer getAvailableStockById(Long id);
}
