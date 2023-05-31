package io.heling.swiftshop.domain.dto;

import java.io.Serializable;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 15:35
 * @description
 */
public class UserDTO implements Serializable {
    private static final long serialVersionUID = -3281829318057273813L;

    //用户名
    private String userName;
    //密码
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
