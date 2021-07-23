package com.base.proxy.dynamic_jdk;

import com.base.proxy.common.RealSubject;
import com.base.proxy.common.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author lryepoch
 * @date 2021/7/22 14:38
 * @description TODO
 */

/**
 * 优点：
 * 由于动态代理是程序运行后才生成的，哪个委托类需要被代理到，只要生成动态代理即可，避免了静态代理那样的硬编码，另外所有委托类实现接口的方法都会在 Proxy
 * 的 InvocationHandler.invoke() 中执行，这样如果要统计所有方法执行时间这样相同的逻辑，可以统一在 InvocationHandler 里写， 也就避免了静态代理那样需
 * 要在所有的方法中插入同样代码的问题，代码的可维护性极大地提高了。
 * <p>
 * 缺点：
 * 第二个参数 Interfaces 是委托类的接口，是必传的， JDK 动态代理是通过与委托类实现同样的接口，然后在实现的接口方法里进行增强来实现的，这就意味着如果要
 * 用 JDK 代理，委托类必须实现接口，这样的实现方式看起来有点蠢，更好的方式是什么呢，直接继承自委托类不就行了，这样委托类的逻辑不需要做任何改动，CGlib 就是这么做的。
 */
public class ProxyFactory {

    //维护一个目标对象
    private Object target;

    public ProxyFactory(Object target) {
        this.target = target;
    }

    //为目标对象生成代理对象
    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("计算开始时间");
                        //执行目标对象方法
                        method.invoke(target, args);
                        System.out.println("计算结束时间");
                        return null;
                    }
                });
    }

    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        System.out.println("原始类：" + realSubject.getClass());
        //装载目标类对象
        ProxyFactory proxyFactory = new ProxyFactory(realSubject);
        //生成代理类对象
        Subject subject = (Subject) proxyFactory.getProxyInstance();
        System.out.println("代理类：" + subject.getClass());
        subject.request();
    }
}
