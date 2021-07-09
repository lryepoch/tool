package com.base.thread.juc1;

import java.util.concurrent.locks.LockSupport;

/**
 * 1思路：使用 LockSupport
 * LockSupport 是 JDK 底层的基于 sun.misc.Unsafe 来实现的类，用来创建锁和其他同步工具类的基本线程
 * 阻塞原语。它的静态方法unpark()和park()可以分别实现阻塞当前线程和唤醒指定线程的效果，所以用它解决
 * 这样的问题会更容易一些。
 * <p>
 * 在 AQS 中，就是通过调用 LockSupport.park()和 LockSupport.unpark() 来实现线程的阻塞和唤醒的。
 */
public class PrintABCUsingLockSupport {

    private static Thread threadA, threadB, threadC;

    public static void main(String[] args) {
        threadA = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //打印当前线程名称
                System.out.print(Thread.currentThread().getName());
                //唤醒下一个线程
                LockSupport.unpark(threadB);
                //当前线程阻塞
                LockSupport.park();
            }
        }, "A");

        threadB = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //先阻塞等待被唤醒
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                //唤醒下一个线程
                LockSupport.unpark(threadC);
            }
        }, "B");

        threadC = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                //先阻塞等待被唤醒
                LockSupport.park();
                System.out.print(Thread.currentThread().getName());
                //唤醒下一个线程
                LockSupport.unpark(threadA);
            }
        }, "C");

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
