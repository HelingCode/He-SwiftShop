package io.heling.swiftshop.infrastructure.repository;

import io.heling.swiftshop.domain.model.SwiftShopUser;
import io.heling.swiftshop.domain.repository.UserRepository;
import io.heling.swiftshop.infrastructure.mapper.UserMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 10:14
 * @description
 */
@Component
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private UserMapper userMapper;

    @Override
    public SwiftShopUser getUserByUserName(String userName) {
        return userMapper.getUserByUserName(userName);
    }
}
