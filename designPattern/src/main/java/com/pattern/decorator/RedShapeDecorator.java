package com.pattern.decorator;

/**
 * @author lryepoch
 * @description 使用 RedShapeDecorator 来装饰 Shape 对象
 * @date 2020/7/7 11:46
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        decoratedShape.draw();
        setRedBorder(decoratedShape);
    }

    private void setRedBorder(Shape decoratedShape) {
        System.out.println("Border Color:Red " + decoratedShape);
    }

}
