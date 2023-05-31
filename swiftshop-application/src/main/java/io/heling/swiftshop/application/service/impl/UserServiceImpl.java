package io.heling.swiftshop.application.service.impl;

import io.heling.swiftshop.application.service.RedisService;
import io.heling.swiftshop.application.service.UserService;
import io.heling.swiftshop.domain.code.HttpCode;
import io.heling.swiftshop.domain.constants.Constants;
import io.heling.swiftshop.domain.exception.SwiftShopException;
import io.heling.swiftshop.domain.model.SwiftShopUser;
import io.heling.swiftshop.domain.repository.UserRepository;
import io.heling.swiftshop.infrastructure.shiro.utils.CommonsUtils;
import io.heling.swiftshop.infrastructure.shiro.utils.JwtUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Objects;

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

    @Resource
    private RedisService redisService;

    @Override
    public SwiftShopUser getUserByUserName(String userName) {
        return userRepository.getUserByUserName(userName);
    }

    @Override
    public String login(String userName, String password) {
        if(StringUtils.isEmpty(userName)){
            throw new SwiftShopException(HttpCode.USERNAME_IS_NULL);
        }
        if(StringUtils.isEmpty(password)) {
            throw new SwiftShopException(HttpCode.PASSWORD_IS_NULL);
        }
        SwiftShopUser user = userRepository.getUserByUserName(userName);
        if(Objects.isNull(user)) {
            throw new SwiftShopException(HttpCode.USERNAME_IS_ERROR);
        }
        String paramsPassword = CommonsUtils.encryptPassword(password, userName);
        if(!paramsPassword.equals(user.getPassword())) {
            throw new SwiftShopException(HttpCode.PASSWORD_IS_ERROR);
        }
        String token = JwtUtils.sign(user.getId());
        String key = Constants.getKey(Constants.USER_KEY_PREFIX, String.valueOf(user.getId()));
        //缓存到Redis
        redisService.set(key,token);
        //返回token
        return token;
    }
}
