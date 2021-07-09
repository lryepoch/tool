package com.base.thread.juc1;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 1思路：使用 Lock/Condition
 * Condition 中的 await() 方法相当于 Object 的 wait() 方法，Condition 中的 signal() 方法相当
 * 于Object 的 notify() 方法，Condition 中的 signalAll() 相当于 Object 的 notifyAll() 方法。
 * <p>
 * 不同的是，Object 中的 wait(),notify(),notifyAll()方法是和"同步锁"(synchronized关键字)捆绑使
 * 用的；而 Condition 是需要与"互斥锁"/"共享锁"捆绑使用的。
 * <p>
 * 使用 Lock 锁的多个 Condition 可以实现精准唤醒，所以碰到那种多个线程交替打印不同次数的题就比较容易想到
 */
public class PrintABCUsingLockCondition {

    private int times;
    private int state;

    private static Lock lock = new ReentrantLock();
    private static Condition c1 = lock.newCondition();
    private static Condition c2 = lock.newCondition();
    private static Condition c3 = lock.newCondition();

    public PrintABCUsingLockCondition(int times) {
        this.times = times;
    }

    private void printLetter(String name, int targetState, Condition current, Condition next) {
        for (int i = 0; i < times; ) {
            lock.lock();
            try {
                while (state % 3 != targetState) {
                    current.await();
                }
                state++;
                i++;
                System.out.println(name);
                next.signal();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        PrintABCUsingLockCondition print = new PrintABCUsingLockCondition(10);

        new Thread(() -> {
            print.printLetter("A", 0, c1, c2);
        }, "A").start();

        new Thread(() -> {
            print.printLetter("B", 1, c2, c3);
        }, "B").start();

        new Thread(() -> {
            print.printLetter("C", 2, c3, c1);
        }, "C").start();
    }
}
