package com.base.thread.juc1;

/**
 * 3思路：使用 wait/notify
 */
public class OddEvenPrinter {
    private Object monitor = new Object();
    private final int limit;
    private volatile int count;

    public OddEvenPrinter(int count, int times) {
        this.limit = times;
        this.count = count;
    }

    private void print() {
        synchronized (monitor) {
            while (count < limit) {
                try {
                    System.out.println(String.format("线程[%s]打印数字：%d", Thread.currentThread().getName(), ++count));
                    monitor.notifyAll();
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //防止有子线程被阻塞未被唤醒，导致主线程不退出
            monitor.notifyAll();
        }
    }

    public static void main(String[] args) {
        OddEvenPrinter printer = new OddEvenPrinter(0, 10);
        new Thread(printer::print, "odd").start();
        new Thread(printer::print, "even").start();
    }
}
