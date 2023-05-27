package io.heling.swiftshop.domain.enums;

/**
 * @author heling
 * @version 1.0.0
 * @date 2023/5/27 14:21
 * @description
 */
public enum ActivityStatus {

    PUBLISHED(0),
    ONLINE(1),
    OFFLINE(-1);

    private final Integer code;

    ActivityStatus(Integer code) {
        this.code = code;
    }

    public static boolean isOffline(Integer status) {
        return OFFLINE.getCode().equals(status);
    }

    public static boolean isOnline(Integer status) {
        return ONLINE.getCode().equals(status);
    }

    public Integer getCode() {
        return code;
    }
}
