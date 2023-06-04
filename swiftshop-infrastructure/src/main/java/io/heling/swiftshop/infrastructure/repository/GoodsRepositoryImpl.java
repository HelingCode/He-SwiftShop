package io.heling.swiftshop.infrastructure.repository;

import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.domain.model.SwiftShopGoods;
import io.heling.swiftshop.domain.repository.GoodsRepostory;
import io.heling.swiftshop.infrastructure.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/4 16:04
 * @description
 */
@Component
public class GoodsRepositoryImpl implements GoodsRepostory {

    @Autowired
    private GoodsMapper goodsMapper;

    @Override
    public int saveGoods(SwiftShopGoods swiftShopGoods) {
        if(Objects.isNull(swiftShopGoods)) {
            throw new SwiftShopException(HttpCode.PARAMS_INVALID);
        }
        return goodsMapper.saveGoods(swiftShopGoods);
    }

    @Override
    public SwiftShopGoods getGoodsById(Long id) {
        return goodsMapper.getGoodsById(id);
    }

    @Override
    public List<SwiftShopGoods> getGoodsByActivityId(Long activityId) {
        return goodsMapper.getGoodsByActivityId(activityId);
    }

    @Override
    public int updateStatus(Integer status, Long id) {
        return goodsMapper.updateStatus(status,id);
    }

    @Override
    public int updateAvailableStock(Integer count, Long id) {
        return goodsMapper.updateAvailableStock(count,id);
    }

    @Override
    public Integer getAvailableStockById(Long id) {
        return goodsMapper.getAvailableStockById(id);
    }
}
