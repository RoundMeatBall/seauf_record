package com.seauf.util;

/**
 * @description:
 * @author: lynn
 * @create: 2019/07/18
 */
public class StringUtils {

    public static Boolean isNotBlank(String str) {
        if (str == null) {
            return false;
        } else {
            return "".equals(str) ? false : true;
        }
    }

}
