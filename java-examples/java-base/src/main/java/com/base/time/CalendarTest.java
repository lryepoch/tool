package com.base.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author lryepoch
 * @date 2021/3/16 10:44
 * @description TODO
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_WEEK,3);
        calendar.add(Calendar.WEEK_OF_MONTH, -1);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(sdf.format(calendar.getTime()));
    }
}
