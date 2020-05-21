package com.baba.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xiechao
 * @version 1.0.0
 * @date 2020/5/19 15:58
 * @description
 */
public class DateUtils {
    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(Long stamp){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.format(new Date(stamp));
    }


    /**
     * 将时间转换为时间戳
     * @param date
     * @return
     * @throws ParseException
     */
    public static Long dateToStamp(String date) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return simpleDateFormat.parse(date).getTime();
    }

    /**
     * 校验时间是否过期
     * @param newStamp 新时间戮值
     * @param oldStamp 旧时间戮值
     * @param expMinute 过期时间，分钟数
     * @return 如果为true则过期，否则未过期
     */
    public static boolean validateDateDiff(Long newStamp, Long oldStamp, Long expMinute){
        Long dateDiff = (newStamp - oldStamp) / (1000 * 60);
        if(dateDiff>expMinute){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(stampToDate(1589874615l));//1970-01-19 17:37:54
        System.out.println(stampToDate(1589874615000l));
        System.out.println(stampToDate(1589871545460l));//2020-05-19 14:59:05
    }
}
