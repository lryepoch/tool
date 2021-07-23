package com.base.proxy.static_proxy;

/**
 * @author lryepoch
 * @date 2021/7/22 14:11
 * @description TODO 代理类实现接口
 */

import com.base.proxy.common.RealSubject;
import com.base.proxy.common.Subject;

/**
 * Java 程序的运行机制：
 * 首先 Java 源代码经过编译生成字节码，然后再由 JVM 经过类加载、连接，初始化成 Java 类型，可以看到字节码是关键，静态和动态的区别就在于字节码生成的时机。
 * <p>
 * 静态代理：由程序员创建代理类或特定工具自动生成源代码再对其编译。在编译时已经将接口、被代理类（委托类）、代理类等确定下来，在程序运行前代理类的.class文件就已经存在了。
 *
 * 静态代理主要有两大劣势：
 * 代理类只代理一个委托类（其实可以代理多个，但不符合单一职责原则），也就意味着如果要代理多个委托类，就要写多个代理（别忘了静态代理在编译前必须确定）。
 * 第一点还不是致命的，再考虑这样一种场景：如果每个委托类的每个方法都要被织入同样的逻辑，比如说我要计算前文提到的每个委托类每个方法的耗时，就要在方法开始前、开始后分别织入计算时间的代码，那就算用代理类，它的方法也有无数这种重复的计算时间的代码。
 * <p>
 * 动态代理：在程序运行后通过反射创建生成字节码再由 JVM 加载而成。
 * 一个代理类可以代理多个代理对象。
 */
public class Proxy implements Subject {

    private RealSubject realSubject;

    public Proxy(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    @Override
    public void request() {
        //执行代理逻辑
        System.out.println("卖房前，看房");

        //执行目标对象方法
        realSubject.request();

        //执行代理逻辑
        System.out.println("卖房后，入住");
    }

    //代理对象操作目标类对象方法
    public static void main(String[] args) {
        //被代理对象(目标类)
        RealSubject subject = new RealSubject();

        //代理
        Proxy proxy = new Proxy(subject);

        //代理请求
        proxy.request();
    }
}
