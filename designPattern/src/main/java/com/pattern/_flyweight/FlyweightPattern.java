package _flyweight;

public class FlyweightPattern {

	FlyweightFactory factory = new FlyweightFactory();
	Flyweight fly1;
	Flyweight fly2;
	Flyweight fly3;

	/** Creates a new instance of FlyweightPattern */

	public FlyweightPattern() {
		fly1 = factory.getFlyweight("Google");
		fly2 = factory.getFlyweight("Qutr");
		fly3 = factory.getFlyweight("Google");

	}

	public void showFlyweight() {
		fly1.operation("Эт");
		fly2.operation("Эт~");
		fly3.operation("Эт");

		int objSize = factory.getFlyweightSize();
		System.out.println("objSize = " + objSize);
	}

	public static void main(String[] args) {

		System.out.println("The FlyWeight Pattern!");
		FlyweightPattern fp = new FlyweightPattern();
		fp.showFlyweight();
		
	}

}
