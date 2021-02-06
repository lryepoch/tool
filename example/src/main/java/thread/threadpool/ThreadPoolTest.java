package thread.threadpool;

import java.util.concurrent.*;

/**
 * @author lryepoch
 * @date 2020/8/17 10:52
 * @description TODO 创建多线程、线程池
 */
public class ThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {

        /**
         * @description new Thread使用多线程
         * @author lryepoch
         * @date 2020/11/30 11:49
         *
         */
//        for (int i = 0; i < 10; i++) {
//            Thread t = new Thread(new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            });
//            Thread.sleep(1000);
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
//            Runnable r = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                }
//            };
//            executorService.execute(r);
//            Thread.sleep(1000);
//        }
//        关闭线程池
//        executorService.shutdown();
//        //此处不可以删除或注释，需要所有子线程执行结束后再执行别的内容，即只有所有子线程结束后才会继续向下执行
//        while (!fixedThreadPool.isTerminated()) {
//
//        }


        /**
         * @description 创建一个可重用固定个数的线程池，以共享的无界队列方式来运行这些线程。
         *              定长线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()
         *
         * @author lryepoch
         * @date 2020/10/17 11:32
         *
         */
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//        for (int i = 0; i < 10; i++) {
//            fixedThreadPool.execute(() -> {
//                System.out.println(Thread.currentThread().getName());
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }
//        //关闭线程池。与使用数据库连接池一样，每次使用完毕后，都要关闭线程池。
//        fixedThreadPool.shutdown();
//
//        //此处不可以删除或注释，需要所有子线程执行结束后再执行别的内容，即只有所有子线程结束后才会继续向下执行
//        while (!fixedThreadPool.isTerminated()) {
//
//        }




        /**
         * @description 自定义线程池
         * @author lryepoch
         * @date 2020/11/30 11:50
         *
         */
//        ExecutorService executorService = new ThreadPoolExecutor(10, 1000, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//        for (int i = 0; i < 100; i++) {
//            Runnable runnable = new Runnable() {
//                @Override
//                public void run() {
//                    System.out.println(Thread.currentThread().getName());
//                    ThreadPoolTest.addCount();
//                    System.out.println(ThreadPoolTest.count);
//                }
//            };
//            executorService.execute(runnable);
//            Thread.sleep(1000);
//        }
//        关闭线程池
//        executorService.shutdown();

//        //此处不可以删除或注释，需要所有子线程执行结束后再执行别的内容，即只有所有子线程结束后才会继续向下执行
//        while (!fixedThreadPool.isTerminated()) {
//
//        }

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
