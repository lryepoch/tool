package com.base.thread.demo2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1思路：使用一个取模的判断逻辑 C%M ==N，题为 3 个线程，所以可以按取模结果编号：0、1、2，
 * 他们与 3 取模结果仍为本身，则执行打印逻辑。
 */
public class PrintABCUsingLock {

    private int times; //控制打印次数
    private int state; //当前状态值，保证三个线程之间交替打印
    private Lock lock = new ReentrantLock();

    public PrintABCUsingLock(int times) {
        this.times = times;
    }

    void printLetter(String name, int targetNum) {
        for (int i = 0; i < times; ) {
            lock.lock();
            if (state % 3 == targetNum) {
                state++;
                i++;
                System.out.println(name);
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLock loopThread = new PrintABCUsingLock(3);

        new Thread(() -> {
            loopThread.printLetter("B", 1);
        }, "B").start();

        new Thread(() -> {
            loopThread.printLetter("A", 0);
        }, "A").start();

        new Thread(() -> {
            loopThread.printLetter("C", 2);
        }, "C").start();
    }
}
