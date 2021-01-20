package org.itstack.demo.design;

/**
* 模拟Spring的HandlerInterceptor
*/
public interface HandlerInterceptor {

    boolean preHandle(String request, String response, Object handler);

}
