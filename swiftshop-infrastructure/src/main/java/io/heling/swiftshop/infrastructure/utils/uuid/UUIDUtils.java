package io.heling.swiftshop.infrastructure.utils.uuid;

import java.util.UUID;


public class UUIDUtils {

    public static String getUUID(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
