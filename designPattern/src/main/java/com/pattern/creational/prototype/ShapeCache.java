package com.pattern.creational.prototype;

import java.util.Hashtable;

public class ShapeCache {
	private static Hashtable<String, Shape> shapeMap = new Hashtable<>();

	// ��ÿ����״���������ݿ��ѯ������������״
	// shapeMap.put(shapeKey, shape);
	// ���磬����Ҫ���������״
	public static void loadCache() {
		Circle circle = new Circle();
		circle.setId("1");
		shapeMap.put(circle.getId(), circle);

		Square square = new Square();
		square.setId("2");
		shapeMap.put(square.getId(), square);

		Rectangle rectangle = new Rectangle();
		rectangle.setId("3");
		shapeMap.put(rectangle.getId(), rectangle);
	}
	
	//����id��ȡ���󣬴Ӷ�����
	public static Shape getShape(String shapeId) {
		Shape cacheShape = shapeMap.get(shapeId);
		return (Shape) cacheShape.clone();
	}

}
