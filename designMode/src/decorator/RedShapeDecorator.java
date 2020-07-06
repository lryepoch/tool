package decorator;

public class RedShapeDecorator extends ShapeDecorator {
	public RedShapeDecorator(Shape decoratedShape){
		super(decoratedShape);
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		decoratedShape.draw();
		setRedBorder(decoratedShape);
	}
	
	private void setRedBorder(Shape decoratedShape){
		System.out.println("Border Color:Red");
	}

}
