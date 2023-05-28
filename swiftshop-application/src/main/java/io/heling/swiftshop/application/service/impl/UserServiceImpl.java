package io.heling.swiftshop.application.service.impl;

import io.heling.swiftshop.application.service.UserService;
import io.heling.swiftshop.domain.model.SwiftShopUser;
import io.heling.swiftshop.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 10:20
 * @description
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public SwiftShopUser getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }
}
