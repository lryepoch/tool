package com.base.proxy.common;

/**
 * @author lryepoch
 * @date 2021/7/22 14:11
 * @description TODO 目标类实现接口
 */
public class RealSubject implements Subject {

    @Override
    public void request() {
        System.out.println("卖房");
    }

}
