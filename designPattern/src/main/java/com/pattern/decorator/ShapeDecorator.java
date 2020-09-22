package com.pattern.decorator;

/**
* @description ³éÏó×°ÊÎÀà
 * @author lryepoch
* @date 2020/7/7 11:45
*
*/
public abstract class ShapeDecorator implements Shape {
	protected Shape decoratedShape;

	public ShapeDecorator(Shape decoratedShape) {
		this.decoratedShape=decoratedShape;
	}

	@Override
	public void draw() {
		decoratedShape.draw();
	}

}
