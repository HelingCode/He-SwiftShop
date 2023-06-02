package io.heling.swiftshop.application.service;

import java.util.concurrent.TimeUnit;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/31 16:51
 * @description
 */
public interface RedisService {

    /**
     * 设置缓存
     */
    void set(String key, Object value);


    /**
     * 设置缓存并设置超时时间
     */
    void set(String key, Object value, long timeout, TimeUnit unit);

    /**
     * 从缓存获取数据
     */
    Object get(String key);
}
