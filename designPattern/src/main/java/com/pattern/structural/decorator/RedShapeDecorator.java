package com.pattern.structural.decorator;

/**
 * @author lryepoch
 * @description ʹ�� RedShapeDecorator ��װ�� Shape ����
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
