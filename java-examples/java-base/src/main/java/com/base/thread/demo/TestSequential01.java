package com.base.thread.demo;

/**
 * @author lryepoch
 * @date 2021/6/28 17:29
 * @description TODO 三个线程无序竞争同步锁, 如果遇上的是自己的数字, 就打印. 这种方式会浪费大量的循环
 */
public class TestSequential01 {
    private volatile int pos = 1;
    private volatile int count = 0;

    public void one(int i) {
        synchronized (this) {
            if (pos == i) {
                System.out.println("T-" + i + " " + count);
                pos = i % 3 + 1;
                count = 0;
            } else {
                count++;
            }
        }
    }

    public static void main(String[] args) {
        TestSequential01 demo = new TestSequential01();
        for (int i = 1; i <= 3; i++) {
            int j = i;
            new Thread(() -> {
                while (true) {
                    demo.one(j);
                }
            }).start();
        }
    }
}
