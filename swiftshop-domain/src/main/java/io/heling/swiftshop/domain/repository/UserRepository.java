package io.heling.swiftshop.domain.repository;

import io.heling.swiftshop.domain.model.SwiftShopUser;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:58
 * @description
 */
public interface UserRepository {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    SwiftShopUser getUserByUserName(String userName);
}
