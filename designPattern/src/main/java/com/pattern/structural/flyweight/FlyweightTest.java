package com.pattern.structural.flyweight;

/**
 * ��Ԫģʽ
 *
 * @author lryepoch
 * @description ��Ԫģʽ�����������е�ͬ��������δ�ҵ�ƥ��Ķ����򴴽��¶���
 * @date 2020/7/7 9:12
 */
public class FlyweightTest {

    FlyweightFactory factory = new FlyweightFactory();
    Flyweight fly1;
    Flyweight fly2;
    Flyweight fly3;

    /**
     * Creates a new instance of FlyweightTest
     */

    public FlyweightTest() {
        fly1 = factory.getFlyweight("Google");
        fly2 = factory.getFlyweight("Qutr");
        fly3 = factory.getFlyweight("Google");

    }

    public void showFlyweight() {
        fly1.operation("��");
        fly2.operation("��~");
        fly3.operation("��");

        int objSize = factory.getFlyweightSize();
        System.out.println("objSize = " + objSize);
    }

    public static void main(String[] args) {

        System.out.println("The FlyWeight Pattern!");
        FlyweightTest fp = new FlyweightTest();
        fp.showFlyweight();

    }

}
