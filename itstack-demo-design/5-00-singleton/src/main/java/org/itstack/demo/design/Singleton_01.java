package org.itstack.demo.design;

/**
* @description 懒汉式单例模式（单线程，线程不安全）
*
* 此种方式的单例确实满足了懒加载，但是如果有多个访问者同时去获取对象实例你可以想象成一堆人在抢厕所，就会造成多个同样的实例并存，从而没有达到单例的要求。
*
* @author      lryepoch
* @date        2020/12/13 22:44
*/
public class Singleton_01 {

    private static Singleton_01 instance;

    private Singleton_01() {
    }

    public static Singleton_01 getInstance(){
        if (null != instance) {
            return instance;
        }
        return new Singleton_01();
    }

}
