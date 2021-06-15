package com.anshark.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


/**
 * @Author GUOYU
 * @Date 2021/6/15
 * @Desc
 */
public class DateUtils {

    public final static String DATE = "yyyy-MM-dd";

    public final static String DATE_TIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 日期转字符串
     *
     * @param date
     * @param type
     * @return
     */
    public static String getDateStr(Date date, String type) {
        SimpleDateFormat sdf = new SimpleDateFormat(type);
        return sdf.format(date);
    }

    /**
     * 字符串转日期
     *
     * @param date
     * @param type
     * @return
     */
    public static Date getDate(String date, String type) {
        Date d = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(type);
            d = sdf.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return d;
    }

    /**
     * 两个日期相差天数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long getDays(Date d1, Date d2) {
        long d1Time = d1.getTime();
        long d2Time = d2.getTime();
        double day = (double) (d2Time - d1Time) / 1000 / 60 / 60 / 24;
        return Math.round(day);
    }

    /**
     * @param n 正代表n天后  负代表n -n天前
     * @return
     */
    public static Date day(int n) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, n);
        Date date = calendar.getTime();
        return date;
    }

}
