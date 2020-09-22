package before.fatherANDson;

//Java中类加载的顺序
class C {
	C() {
		System.out.print("C");
	}
}

class A {
	C c = new C();

	A() {
		this("A");
		System.out.print("A");
	}

	A(String s) {
		System.out.print(s);
	}
}

public class other extends A {
	other() {
		// super("B");//显示调用父类的构造函数，不显示则默认调用父类的无参构造器
		System.out.print("B");
	}

	public static void main(String[] args) {
		new other();
	}
}


//
//public class other{
//
//	private int age;
//	private String name;
//
//	public other(int age, String name) {
//		this.age = age;
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public static void main(String args[]) {
//		int n = 0;
//		other person = new other(28, "zhansan"); // 初始化默认值是这样子
//		System.out.println("person1:" + person);
//		person.Uname(person);
//		person.Pname(person);
//		person.cname(n);
//		System.out.println("main:" + n);
//	}
//
//	public void Uname(lry person) {
//		person.age = 8; // 赋予新的值
//		person.name = "L"; // 赋予新的值
//		System.out.println("person2:" + person);
//		System.out.println(this.age);
//	}
//
//	public void Pname(lry person) {
//		person.age = 7;
//		System.out.println("person3:" + person);
//	}
//
//	public void cname(int n) {
//		n = n + 2;
//		System.out.println("cname:" + n);
//	}
//}




//public class other {
//	public static void main(String[] args) {
//		try {
//			int i = 100 / 0;
//			System.out.println(i);
//		} catch (Exception e) {
//			System.out.println(1);
//			throw new RuntimeException();
//		} finally {
//			System.out.println(2);
//		}
//		System.out.println(3);
//	}
//}

/*
//**
* Java可以自动编译
* @author martylee
*
*向下转型需要强制转换
*
*//*
class Base
{
  public void method()
  {
      System.out.println("Base");
  } 
}
class Son extends Base
{
  public void method()
  {
      System.out.println("Son");
  }
   
  public void methodB()
  {
      System.out.println("SonB");
  }
}
public class HelloWorld
{
  public static void main(String[] args)
  {
      Base base = new Son();//向上转型
      base.method();//父类丢失了methodB方法,所以 base.methodB();会出错
    //base.methodB();
      
      Son son=(Son)base;//向下转型,编译无错，运行无错，向下需要强制转换
      son.method();
      son.methodB();
      
      Base base2=new Base();
      Son son2=(Son) base2;//向下转型，编译无错，运行无错
      son2.method();
      son2.methodB();
      
  }
}
*/





