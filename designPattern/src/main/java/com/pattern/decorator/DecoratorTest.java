package com.pattern.decorator;

/**
 * 装饰器模式
 *
 * @author lryepoch
 * @description 向一个现有的对象动态添加新的功能，同时又不改变其结构。
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
