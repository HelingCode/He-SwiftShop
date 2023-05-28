package io.heling.swiftshop.infrastructure.mapper;

import io.heling.swiftshop.domain.model.SwiftShopUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 10:09
 * @description
 */
public interface UserMapper {

    /**
     * 根据用户名获取用户信息
     * @param userName
     * @return
     */
    SwiftShopUser getUserByUserName(@Param("userName") String userName);
}
