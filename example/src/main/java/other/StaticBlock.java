package other;

//静态代码块和构造函数之间执行顺序
class SBlock{
	static double rootof2;
	static double rootof3;
	
	static{
		System.out.println("Inside static block.");
		rootof2=Math.sqrt(2.0);
		rootof3=Math.sqrt(3.0);
	}
	
	SBlock(String msg){
		System.out.println(msg);
	}
}
public class StaticBlock {
	public static void main(String args[]){
		
		SBlock ob=new SBlock("Inside Constructor");
		System.out.println("Sqrt root of 2 is"+SBlock.rootof2);
		System.out.println("Sqrt root of 3 is"+SBlock.rootof3);
	}

}
