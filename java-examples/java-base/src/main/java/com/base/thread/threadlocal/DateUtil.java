package com.base.thread.threadlocal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 读取日期
 */
public class DateUtil {

    /**
     * @description 出现NumberException异常。SimpleDateFormat类线程不安全
     * @author lryepoch
     * @date 2020/12/1 8:50
     */
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date parse(String dateStr) {
        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @description 1.每次来都new新的，空间浪费比较大
     * @author lryepoch
     * @date 2020/12/1 8:51
     */
    public static Date parse1(String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        Date date = null;
        try {
            date = sdf.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    /**
     * @description 2.方法用synchronized修饰，并发上不来
     * @author lryepoch
     * @date 2020/12/1 8:54
     */
    private static final SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static synchronized Date parse2(String dateStr) {
        Date date = null;
        try {
            date = sdf2.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //3.用jdk1.8中的日期格式类DateFormatter，DateTimeFormatter、

    /**
     * @description 4.用ThreadLocal，一个线程一个SimpleDateFormat对象（全局->threadlocal线程独有的一份）
     * @author lryepoch
     * @date 2020/12/1 9:19
     */
    private static ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static Date parse4(String dateStr) {
        Date date = null;
        try {
            date = threadLocal.get().parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(20);
        for (int i = 0; i < 20; i++) {
            service.execute(() -> {
                System.out.println(DateUtil.parse4("2019-06-01 16:34:30"));
            });
        }
        service.shutdown();
    }
}
