package com.base.thread.threadpool;

import java.util.concurrent.*;

/**
 * @author lryepoch
 * @date 2020/8/17 10:52
 * @description TODO 创建多线程、线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {

        /**
         * @description new Thread使用多线程，启动10个线程
         * @author lryepoch
         * @date 2020/11/30 11:49
         *
         */
//        for (int i = 0; i < 10; i++) {
//
//            Thread t = new Thread(new Runnable() {
//
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//
//            Thread.sleep(1000);
//
//            t.start();
//        }


        /**
         * @description 线程池为无限大，当执行当前任务时上一个任务已经完成，会复用执行上一个任务的线程，而不用每次新建线程
         * @author lryepoch
         * @date 2020/11/30 11:49
         *
         */
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        for (int i = 0; i < 10; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            };
//            executorService.execute(runnable);
//            Thread.sleep(1000);
//        }
//
//        //关闭线程池
//        executorService.shutdown();
//
//        /**
//         isTerminated()函数判断线程池中的所有线程是否执行完毕时候，不能直接使用该函数，必须在shutdown()方法关闭线程池之后才能使用，
//         否则isTerminated()永不为TRUE，线程将一直阻塞在该判断的地方，导致程序最终崩溃。
//         当其中任务执行完成的时候，isTerminated()才为true;
//         */
//        //此处不可以删除或注释，只有所有子线程结束后才会继续向下执行
//        while (!executorService.isTerminated()) {
//             System.out.println("子线程还在执行任务！");
//        }
//        System.out.println("所有子线程执行任务完毕！");

        /**
         * @description 创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
         *              定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
         *
         * @author lryepoch
         * @date 2020/10/17 11:32
         *
         */
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(2);
//
//        for (int i = 0; i < 10; i++) {
//
//            fixedThreadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//
//        //关闭线程池。与使用数据库连接池一样，每次使用完毕后，都要关闭线程池。
//        fixedThreadPool.shutdown();
//
//        //此处不可以删除或注释，需要所有子线程执行结束后再执行别的内容，即只有所有子线程结束后才会继续向下执行
//        while (!fixedThreadPool.isTerminated()) {
//            System.out.println("子线程还在执行任务！");
//        }
//
//        System.out.println("所有子线程执行任务完毕！");


        /**
         * @description 自定义线程池
         * @author lryepoch
         * @date 2020/11/30 11:50
         *
         */
//        ExecutorService executorService = new ThreadPoolExecutor(10, 1000, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//        for (int i = 0; i < 30; i++) {
//            //定义线程任务
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                    ThreadPoolTest.addCount();
//                    System.out.println(ThreadPoolTest.count);
//                }
//            };
//            //线程池10个子线程同时执行任务
//            executorService.execute(runnable);
//            //Thread.sleep(100);
//        }
//
//        //关闭线程池
//        executorService.shutdown();
//
//        //此处不可以删除或注释，需要所有子线程执行结束后再执行别的内容，即只有所有子线程结束后才会继续向下执行
//        while (!executorService.isTerminated()) {
//            System.out.println("子线程还在执行任务！");
//        }
//        System.out.println("所有子线程执行任务完毕！");

    }

    public static int count = 0;

    public static int getCount() {
        return count;
    }

    //存在同步异常
    public synchronized static void addCount() {
        count++;
    }

}
