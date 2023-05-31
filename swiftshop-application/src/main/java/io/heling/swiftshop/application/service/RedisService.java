package io.heling.swiftshop.application.service;

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
}
