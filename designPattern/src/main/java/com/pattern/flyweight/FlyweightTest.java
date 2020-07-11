package com.pattern.flyweight;

/**
 * 享元模式
 *
 * @author lryepoch
 * @description 享元模式尝试重用现有的同类对象，如果未找到匹配的对象，则创建新对象。
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
        fly1.operation("外");
        fly2.operation("外~");
        fly3.operation("外");

        int objSize = factory.getFlyweightSize();
        System.out.println("objSize = " + objSize);
    }

    public static void main(String[] args) {

        System.out.println("The FlyWeight Pattern!");
        FlyweightTest fp = new FlyweightTest();
        fp.showFlyweight();

    }

}
