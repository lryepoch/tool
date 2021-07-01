package com.base.thread.demo;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lryepoch
 * @date 2021/6/29 11:19
 * @description TODO 给每个线程不同的condition. 可以用condition.signal()精确地通知对应的线程继续执行(在对应的condition上await的线程, 可能是多个)
 */
public class TestSequential04 {
    private static Lock lock = new ReentrantLock();
    private static Condition[] conditions = {lock.newCondition(), lock.newCondition(), lock.newCondition()};
    private volatile int state = 1;

    private void run(final int self) {
        int next = self % 3 + 1;

        while (true) {
            lock.lock();

            while (this.state != self) {
                try {
                    conditions[self - 1].await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println(self);
            this.state = next;
            conditions[next - 1].signal();

            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TestSequential04 rls = new TestSequential04();
        for (int i = 1; i < 4; i++) {
            int j = i;
            new Thread(() -> rls.run(j)).start();
        }
    }
}
