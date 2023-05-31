package io.heling.swiftshop.domain.exception;

import io.heling.swiftshop.domain.code.HttpCode;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/28 15:42
 * @description
 */
public class SwiftShopException extends RuntimeException{

    private Integer code;

    public SwiftShopException(String message) {
        super(message);
    }

    public SwiftShopException(HttpCode errorCode){
        this(errorCode.getCode(), errorCode.getMesaage());
    }

    public SwiftShopException(Integer code, String messgae){
        super(messgae);
        this.code = code;
    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
