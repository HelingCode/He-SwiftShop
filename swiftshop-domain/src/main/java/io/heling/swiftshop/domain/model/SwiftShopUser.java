package io.heling.swiftshop.domain.model;

import java.io.Serializable;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:03
 * @description
 */
public class SwiftShopUser implements Serializable {

    private static final long serialVersionUID = 6114583645611107822L;

    // 用户id
    private Long id;
    //用户名
    private String userName;
    //密码
    private String password;
    //1：正常；2：冻结
    private Integer status;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
