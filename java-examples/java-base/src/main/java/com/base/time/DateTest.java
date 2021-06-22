package com.base.time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateTest {
    public static void main(String[] args) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        Calendar calendar = new GregorianCalendar();

        calendar.setTime(new Date());

        calendar.add(calendar.DATE,-1);

        String date2= sdf.format(calendar.getTime());

        System.out.println(date2);
    }
}
