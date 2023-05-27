package io.heling.swiftshop.domain.enums;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:22
 * @description
 */
public enum OrderStatus {

    CREATED(1),
    PAID(2),
    CANCELED(0),
    DELETED(-1);

    private final Integer code;

    OrderStatus(Integer code) {
        this.code = code;
    }

    public static boolean isCancled(Integer code) {
        return CANCELED.getCode().equals(code);
    }

    public static boolean isDeleted(Integer status) {
        return DELETED.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}
