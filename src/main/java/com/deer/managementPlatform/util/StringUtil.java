package com.deer.managementPlatform.util;

import java.util.UUID;

/**
 * @author Star
 * @version 1.0
 * @date 2020/9/20 15:27
 */
public class StringUtil {
    public static String getUuid(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
