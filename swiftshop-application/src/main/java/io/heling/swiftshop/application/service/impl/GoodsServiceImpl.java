package io.heling.swiftshop.application.service.impl;

import io.heling.swiftshop.application.service.GoodsService;
import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.dto.GoodsDTO;
import io.heling.swiftshop.domain.enums.GoodsStatus;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.domain.model.SwiftShopActivity;
import io.heling.swiftshop.domain.model.SwiftShopGoods;
import io.heling.swiftshop.domain.repository.ActivityRepository;
import io.heling.swiftshop.domain.repository.GoodsRepostory;
import io.heling.swiftshop.infrastructure.utils.beans.BeanUtil;
import io.heling.swiftshop.infrastructure.utils.id.SnowFlakeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/6/4 16:11
 * @description
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsRepostory goodsRepostory;

    @Autowired
    private ActivityRepository activityRepository;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int saveGoods(GoodsDTO goodsDTO) {
        if(Objects.isNull(goodsDTO)) {
            throw new SwiftShopException(HttpCode.PARAMS_INVALID);
        }
        SwiftShopActivity activityById = activityRepository.getActivityById(goodsDTO.getActivityId());
        if(Objects.isNull(activityById)) {
            throw new SwiftShopException(HttpCode.ACTIVITY_NOT_EXISTS);
        }
        SwiftShopGoods swiftShopGoods = new SwiftShopGoods();
        BeanUtil.copyProperties(goodsDTO,swiftShopGoods);
        swiftShopGoods.setStartTime(activityById.getStartTime());
        swiftShopGoods.setEndTime(activityById.getEndTime());
        swiftShopGoods.setAvailableStock(goodsDTO.getInitialStock());
        swiftShopGoods.setId(SnowFlakeFactory.getSnowFlakeFromCache().nextId());
        swiftShopGoods.setStatus(GoodsStatus.PUBLISHED.getCode());
        return goodsRepostory.saveGoods(swiftShopGoods);
    }

    @Override
    public SwiftShopGoods getGoodsById(Long id) {
        return goodsRepostory.getGoodsById(id);
    }

    @Override
    public List<SwiftShopGoods> getGoodsByActivityId(Long activityId) {
        return goodsRepostory.getGoodsByActivityId(activityId);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateStatus(Integer status, Long id) {
        return goodsRepostory.updateStatus(status,id);
    }

    @Override
    public int updateAvailableStock(Integer count, Long id) {
        return goodsRepostory.updateAvailableStock(count,id);
    }

    @Override
    public Integer getAvailableStockById(Long id) {
        return goodsRepostory.getAvailableStockById(id);
    }
}
