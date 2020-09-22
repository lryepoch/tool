package com.pattern.creational.singleton;

/**
 * ����ģʽ
 *
 * @author lryepoch
 * @description ��֤һ�������һ��ʵ�������ṩһ����������ȫ�ַ��ʵ�
 * @date 2020/7/7 10:41
 */
public class SingletonTest {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        SingleObject singleObject = SingleObject.getInstance();
        singleObject.showMessage();
    }

}
