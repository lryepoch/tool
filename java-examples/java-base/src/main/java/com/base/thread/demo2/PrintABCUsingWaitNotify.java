package com.base.thread.demo2;

/**
* 1思路：还是以第一题为例，我们用对象监视器来实现，通过 wait 和 notify() 方法来实现等待、通知的逻辑，
 * A 执行后，唤醒 B，B 执行后唤醒 C，C 执行后再唤醒 A，这样循环的等待、唤醒来达到目的。
*/
public class PrintABCUsingWaitNotify {

    private int state;
    private int times;
    private static final Object LOCK = new Object();

    public PrintABCUsingWaitNotify(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetState) {
        for (int i = 0; i < times; i++) {
            synchronized (LOCK) {
                while (state % 3 != targetState) {
                    try {
                        LOCK.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                state++;
                System.out.println(name);
                LOCK.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingWaitNotify printABC = new PrintABCUsingWaitNotify(10);
        new Thread(() -> {
            printABC.printLetter("A", 0);
        }, "A").start();

        new Thread(() -> {
            printABC.printLetter("B", 1);
        }, "B").start();

        new Thread(() -> {
            printABC.printLetter("C", 2);
        }, "C").start();
    }

}
