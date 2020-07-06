package _abstractFactory;

public class AbstractFactoryPattern {

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
