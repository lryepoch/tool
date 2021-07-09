package com.base.thread.juc1;

import java.util.concurrent.locks.LockSupport;

/**
 * 5思路：LockSupport
 */
public class NumAndLetterPrinter {

    private static Thread numThread, letterThread;

    public static void main(String[] args) {
        letterThread = new Thread(() -> {
            for (int i = 0; i < 26; i++) {
                System.out.println((char) ('A' + i));
                LockSupport.unpark(numThread);//唤醒下一个线程
                LockSupport.park();//阻塞当前线程
            }
        }, "letterThread");

        numThread = new Thread(() -> {
            for (int i = 1; i <= 26; i++) {
                System.out.println(i);
                LockSupport.park();//阻塞当前线程
                LockSupport.unpark(letterThread);//唤醒下一个线程
            }
        }, "numThread");

        numThread.start();
        letterThread.start();
    }
}
