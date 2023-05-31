package io.heling.swiftshop.application.service;

import io.heling.swiftshop.domain.model.SwiftShopUser;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 10:20
 * @description
 */
public interface UserService {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    SwiftShopUser getUserByUserName(String userName);

    /**
     * 登录
     * @param userName
     * @param password
     * @return
     */
    String login(String userName, String password);
}
