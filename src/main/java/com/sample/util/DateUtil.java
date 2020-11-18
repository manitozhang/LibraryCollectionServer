package com.sample.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: 张
 * @Email: 1271396448@qq.com
 * @Date: 2020/11/18
 * @DESC:
 */
public class DateUtil {
    /**
     * 获取当前时间
     * @return
     */
    public static String getCurrentDateTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
    }

}
