package org.itstack.demo.design;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author lryepoch
 * @description 静态类使用。为什么要使用单例模式
 * <p>
 * 以下这种方式在我们平常的业务开发中非常常见，这样静态类的方式可以在第一次运行的时候直接初始化Map类，同时这里我们也不需要直到延迟加载再使用。
 * 在不需要维持任何状态下，仅仅用于全局访问，这个使用静态类的方式更加方便。
 * <p>
 * 但如果需要被继承以及需要维持一些特定状态的情况下，就适合使用单例模式。
 * @date 2020/12/13 22:58
 */
public class Singleton_00 {

    public static Map<String, String> cache = new ConcurrentHashMap<String, String>();

}
