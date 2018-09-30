package com.dyx.wacd.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    public static String dateToStamp(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    public static String stampToNewData(String timestamp) {
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(Long.valueOf(timestamp) * 1000));
        return date;
    }
}
