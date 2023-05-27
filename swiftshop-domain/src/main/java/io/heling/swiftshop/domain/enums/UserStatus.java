package io.heling.swiftshop.domain.enums;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:18
 * @description
 */
public enum UserStatus {
    NORMAL(1),
    FREEZE(2);

    private final Integer code;

    UserStatus(Integer code) {
        this.code = code;
    }

    public static boolean isNormal(Integer status) {
        return NORMAL.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}
