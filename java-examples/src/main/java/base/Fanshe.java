package base;

//对象和类的反射
public class Fanshe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fanshe f = new Fanshe();
		if(f.getClass()==Fanshe.class)
		{
			System.out.println("equals");
			System.out.println(f.getClass());
			System.out.println(Fanshe.class);
		}
		else System.out.println("unequals");

	}

}
