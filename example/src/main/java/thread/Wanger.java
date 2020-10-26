package thread;

import lombok.SneakyThrows;

import java.util.concurrent.*;

/**
 * @author lryepoch
 * @date 2020/8/17 10:52
 * @description TODO
 */
public class Wanger {
    public static void main(String[] args) throws InterruptedException {
        //1
        /*        for (int i=0;i<10;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("��"+Thread.currentThread().getName()+"���߳�����");
                }
            });
            Thread.sleep(1000);
            t.start();
        }*/


        //2
        /*ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Runnable r = new Runnable() {
                @Override
                public void run() {
                    System.out.println("�ҽ�" + Thread.currentThread().getName() + ",--");
                }
            };
            executorService.execute(r);
            Thread.sleep(1000);
        }
        executorService.shutdown();*/


        /**
        * @description 在for循环中使用线程池对象获取线程
        * @author lryepoch
        * @date 2020/10/17 11:32
        *
        */
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            fixedThreadPool.execute(new Runnable() {
                @SneakyThrows
                @Override
                public void run() {
                    System.out.println("what");
                    Thread.sleep(2000);
                }
            });
        }

        fixedThreadPool.shutdown();//关闭线程池
        //此处不可以删除或注释，需要线程执行结束后再执行别的内容,即只有线程结束后才会继续向下执行
        while (!fixedThreadPool.isTerminated()) {

        }


        //3
//        ExecutorService executorService = new ThreadPoolExecutor(10, 1000, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));
//        for (int i = 0; i < 1000; i++) {
//            Runnable r = new Runnable() {
//                @Override
//                public void run() {
//                    Wanger.addCount();
//                }
//            };
//            executorService.execute(r);
//        }
//        executorService.shutdown();
//        System.out.println(Wanger.count);
    }

    public static int count = 0;

    public static int getCount() {
        return count;
    }

    public synchronized static void addCount() {
        count++;
    }

}
