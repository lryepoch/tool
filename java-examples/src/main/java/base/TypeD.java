package base;

public class TypeD {
	public static void main(String args[]){
		
		//基本类和封装类转换
		Integer a=new Integer(1);
		Boolean b=new Boolean(true);
		Float f=new Float(-2.4);
		Double d=new Double(1.4);
		Character ch=new Character('A');
		Character ch2=new Character('A');
		int i=a.intValue();
		char c=ch.charValue();
		System.out.println(i);
		System.out.println(b.booleanValue());
		System.out.println(f.floatValue());
		System.out.println(d.doubleValue());
		System.out.println(c);
		System.out.println(ch.equals(ch2));
		System.out.println(ch==ch2);
		System.out.println(d.toString());
		
		
	}

}
