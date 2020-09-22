package com.pattern.abstractFactory;

/**
 * 抽象工厂模式
 *
 * @author lryepoch
 * @description 围绕一个超级工厂创建其他工厂。接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。
 * @date 2020/7/7 10:52
 */
public class AbstractFactoryTest {

    //main方法调用工厂生成器
    public static void main(String[] args) {

        //创建哪一个工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        //创建哪一个产品
        Shape shape1 = shapeFactory.getShape("circle");
        shape1.draw();

        Shape shape2 = shapeFactory.getShape("rectangle");
        shape2.draw();

        Shape shape3 = shapeFactory.getShape("square");
        shape3.draw();


        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        Color color1 = colorFactory.getColor("red");
        color1.fill();

        Color color2 = colorFactory.getColor("green");
        color2.fill();

        Color color3 = colorFactory.getColor("blue");
        color3.fill();
    }

}
