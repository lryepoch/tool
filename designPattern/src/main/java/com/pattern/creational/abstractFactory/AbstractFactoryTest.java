package com.pattern.creational.abstractFactory;

/**
 * ���󹤳�ģʽ
 *
 * @author lryepoch
 * @description Χ��һ�������������������������ӿ��Ǹ��𴴽�һ����ض���Ĺ���������Ҫ��ʽָ�����ǵ��ࡣÿ�����ɵĹ������ܰ��չ���ģʽ�ṩ����
 * @date 2020/7/7 10:52
 */
public class AbstractFactoryTest {

    //main�������ù���������
    public static void main(String[] args) {

        //������һ������
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");
        //������һ����Ʒ
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
