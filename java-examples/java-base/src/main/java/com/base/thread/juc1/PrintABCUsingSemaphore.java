package com.base.thread.juc1;

import java.util.concurrent.Semaphore;

/**
 * 1思路：使用 Semaphore
 * 在信号量上我们定义两种操作： 信号量主要用于两个目的，一个是用于多个共享资源的互斥使用，另一个用于并发线程数的控制。
 * <p>
 * acquire（获取） 当一个线程调用 acquire 操作时，它要么通过成功获取信号量（信号量减1），要么一直等下去，直到有线程释放信号量，或超时。
 * release（释放）实际上会将信号量的值加1，然后唤醒等待的线程。
 * <p>
 * 如果题目中是多个线程循环打印的话，一般使用信号量解决是效率较高的方案，上一个线程持有下一个线程的信号量，
 * 通过一个信号量数组将全部关联起来，这种方式不会存在浪费资源的情况。
 */
public class PrintABCUsingSemaphore {

    private int times;
    private static Semaphore semaphoreA = new Semaphore(1);
    private static Semaphore semaphoreB = new Semaphore(0);
    private static Semaphore semaphoreC = new Semaphore(0);

    public PrintABCUsingSemaphore(int times) {
        this.times = times;
    }

    private void print(String name, Semaphore current, Semaphore next) {
        for (int i = 0; i < times; i++) {
            try {
                System.out.println("111" + Thread.currentThread().getName());
                current.acquire();      // A获取信号执行,A信号量减1,当A为0时将无法继续获得该信号量
                System.out.println(name);
                next.release();         // B释放信号，B信号量加1（初始为0），此时可以获取B信号量
                System.out.println("222" + Thread.currentThread().getName());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingSemaphore printer = new PrintABCUsingSemaphore(1);

        new Thread(() -> {
            printer.print("A", semaphoreA, semaphoreB);
        }, "A").start();

        new Thread(() -> {
            printer.print("B", semaphoreB, semaphoreC);
        }, "B").start();

        new Thread(() -> {
            printer.print("C", semaphoreC, semaphoreA);
        }, "C").start();
    }
}
