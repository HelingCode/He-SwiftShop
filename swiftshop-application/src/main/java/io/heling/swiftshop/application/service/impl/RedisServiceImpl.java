package io.heling.swiftshop.application.service.impl;

import io.heling.swiftshop.application.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/31 16:53
 * @description
 */
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }
}
