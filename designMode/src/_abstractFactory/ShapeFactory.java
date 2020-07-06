package _abstractFactory;

//���ݾ����shape�����������

public class ShapeFactory extends AbstractFactory{
	
	@Override
	public Shape getShape(String shapeType){
		if(shapeType==null){
			return null;
		}
		if(shapeType.equalsIgnoreCase("circle")){
			return new Circle();
		}
		else if(shapeType.equalsIgnoreCase("rectangle")){
			return new Rectangle();
		}
		else if(shapeType.equalsIgnoreCase("SQUARE")){
			return new Square();
		}
	
		return null;
	}

	@Override
	public Color getColor(String color) {
		// TODO �Զ����ɵķ������
		return null;
	}
}
