package com.pattern.creational.singleton;


public class SingletonTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
    }

}
