package com.base.thread.getThreadName;

/**
 * 获取线程名
 */
public class GetThreadNameTest {
    public static void main(String[] args) {
        Thread a = new Thread();
        Thread b = new Thread();
        Thread c = new Thread();
        System.out.println(a.getName());
        System.out.println(b.getName());
        System.out.println(c.getName());
        System.out.println("-------------");
        System.out.println(Thread.currentThread().getName());
    }
}
