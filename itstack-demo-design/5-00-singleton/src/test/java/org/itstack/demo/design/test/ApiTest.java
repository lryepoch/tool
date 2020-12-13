package org.itstack.demo.design.test;

import org.itstack.demo.design.Singleton_00;
import org.itstack.demo.design.Singleton_07;
import org.junit.Test;

/**
* @Description 一个全局使用的类频繁的创建和消费，从而提升提升整体的代码的性能。
 *             保证一个类只有一个实例哪怕多线程同时访问，并需要提供一个全局访问此实例的点。
 *
* @Author       lryepoch
* @CreateDate   2020/12/13 22:49
*/
public class ApiTest {

    @Test
    public void test() {
        Singleton_07.INSTANCE.test();
    }

}
