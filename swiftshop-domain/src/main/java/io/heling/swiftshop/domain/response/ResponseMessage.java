package io.heling.swiftshop.domain.response;

import java.io.Serializable;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:33
 * @description
 */
public class ResponseMessage<T> implements Serializable {
    private static final long serialVersionUID = -992321040478357462L;

    private Integer code;

    private T data;

    public ResponseMessage() {
    }

    public ResponseMessage(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public ResponseMessage(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
