package proxy;

public class ProxyPatternDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Image image= new ProxyImage("3333.jpg");
		image.display();
		System.out.println("");
		image.display();
	}

}
