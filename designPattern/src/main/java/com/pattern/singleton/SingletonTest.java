package com.pattern.singleton;

/**
 * 单例模式
 *
 * @author lryepoch
 * @description 保证一个类仅有一个实例，并提供一个访问它的全局访问点
 * @date 2020/7/7 10:41
 */
public class SingletonTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
    }

}
