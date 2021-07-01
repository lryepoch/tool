package com.base.thread.demo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lryepoch
 * @date 2021/6/29 11:12
 * @description TODO 使用可重入锁
 */
public class TestSequential03 {

    //使用可重入锁, 非公平锁, 三个线程竞争, 如果遇上的是自己的数字, 就打印. 这种方式会浪费大量的循环
//    private final Lock lock = new ReentrantLock();

    //使用可重入锁, 启用公平锁, 这种情况下基本上可以做到顺序执行, 偶尔会产生多一次循环
    private final Lock lock = new ReentrantLock(true);
    private volatile int pos = 1;
    private volatile int count = 0;

    public void run(int i) {
        int next = i % 3 + 1;

        while (true) {
            lock.lock();

            if (pos == i) {
                System.out.println("T-" + i + " " + count);
                pos = next;
                count = 0;
            } else {
                count++;
            }

            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestSequential03 demo = new TestSequential03();
        for (int i=1; i<=3; i++){
            int j=i;
            new Thread(()->{
                demo.run(j);
            }).start();
        }
    }
}


