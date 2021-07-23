package com.base.proxy.dynamic_cglib;


import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author lryepoch
 * @date 2021/7/22 15:51
 * @description TODO
 */
/**
* 利用 Enhancer 这个类来设置委托类与方法拦截器，这样委托类的所有非 final 方法就能被方法拦截器拦截，从而在拦截器里实现增强。
 *  Spring AOP 最终使用了 CGlib 来生成动态代理。
*/
public class MyMethodInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("目标类增强前！！！");
        //注意这里的方法调用，不是用反射哦！！！
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("object：" + object);
        System.out.println("目标类增强后！！！");
        return o;
    }
}
