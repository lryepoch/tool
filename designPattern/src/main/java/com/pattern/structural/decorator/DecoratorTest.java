package com.pattern.structural.decorator;

/**
 * װ����ģʽ
 *
 * @author lryepoch
 * @description ��һ�����еĶ���̬����µĹ��ܣ�ͬʱ�ֲ��ı���ṹ��
 * @date 2020/7/7 11:31
 */
public class DecoratorTest {

    public static void main(String[] args) {
        Shape circle = new Circle();

        Shape redCircle = new RedShapeDecorator(new Circle());

        Shape redRectangle = new RedShapeDecorator(new Rectangle());
        System.out.println("Circle with normal border");
        circle.draw();

        System.out.println("\n Circle of red border");
        redCircle.draw();

        System.out.println("\n Rectangle of the border");
        redRectangle.draw();

    }

}
