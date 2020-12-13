package org.itstack.demo.design;

/**
* @Description  懒汉式单例模式（通过同步方法保证线程安全）
 *
 * 此种模式虽然是安全的，但由于把锁加到方法上后，所有的访问都因需要锁占用导致资源的浪费。如果不是特殊情况下，不建议此种方式实现单例模式。
 *
* @Author       lryepoch
* @CreateDate   2020/12/13 22:55
*/
public class Singleton_02 {

    private static Singleton_02 instance;

    private Singleton_02() {
    }

    public static synchronized Singleton_02 getInstance(){
        if (null != instance) {
            return instance;
        }
        return new Singleton_02();
    }

}
