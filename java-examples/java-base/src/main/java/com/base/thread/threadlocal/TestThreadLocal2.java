package com.base.thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lryepoch
 * @date 2020/12/3 16:57
 * @description TODO 由于线程池的线程是可以重复使用的，所以就出现了数据错乱的现象。所以在和线程池结合使用时，需要注意及时清理线程的数据。
 */
public class TestThreadLocal2 {
    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    /**
     * 线程本地存储变量累加到 5
     */
    private static void add10ByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            THREAD_LOCAL_NUM.set(n);
            System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
        }
        //及时清理线程的数据
        THREAD_LOCAL_NUM.remove();
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService cachedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            cachedThreadPool.execute(() -> add10ByThreadLocal());
            TimeUnit.SECONDS.sleep(5);
        }
    }
}
