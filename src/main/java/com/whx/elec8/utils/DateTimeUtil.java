package com.whx.elec8.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator--善知  on 2018/6/28.
 */
public class DateTimeUtil {
    public static String getNow_YYYY_MM_DD(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return simpleDateFormat.format(new Date());
    }
}
