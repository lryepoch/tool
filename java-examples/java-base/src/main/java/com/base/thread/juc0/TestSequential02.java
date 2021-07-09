package com.base.thread.juc0;

/**
 * @author lryepoch
 * @date 2021/6/29 9:19
 * @description TODO 竞争同步锁时使用wait()和notifyAll(), 可以避免浪费循环
 */
public class TestSequential02 {
    private volatile int pos = 1;
    private volatile int count = 0;
    private final Object obj = new Object();

    public void run(int i) {
        int next = i % 3 + 1;

        /**
         * 在使用wait()和await()的竞争环境, 因为被notifyAll()和signal()之后到线程回到执行之前, 条件可能发生变化,
         * 所以必须在wait()和await()外包使用while循环检测条件, 这是一个通用方法
         */
        while (true) {
            synchronized (obj) {
                System.out.println(i + "in");

                while (pos != i) {
                    count++;
                    System.out.println(i + "wait");
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("T-" + i);
                pos = next;
                count = 0;
                obj.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        TestSequential02 demo = new TestSequential02();
        for (int i = 3; i >= 1; i--) {
            int j = i;
            new Thread(() -> {
                demo.run(j);
            }).start();
        }
    }
}
