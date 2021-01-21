package father_son_class;

//Java������ص�˳��
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
		// super("B");//��ʾ���ø���Ĺ��캯��������ʾ��Ĭ�ϵ��ø�����޲ι�����
		System.out.print("B");
	}

	public static void main(String[] args) {
		new other();
	}
}


//
//public class base{
//
//	private int age;
//	private String name;
//
//	public base(int age, String name) {
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
//		base person = new base(28, "zhansan"); // ��ʼ��Ĭ��ֵ��������
//		System.out.println("person1:" + person);
//		person.Uname(person);
//		person.Pname(person);
//		person.cname(n);
//		System.out.println("main:" + n);
//	}
//
//	public void Uname(lry person) {
//		person.age = 8; // �����µ�ֵ
//		person.name = "L"; // �����µ�ֵ
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




//public class base {
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
* Java�����Զ�����
* @author martylee
*
*����ת����Ҫǿ��ת��
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
      Base base = new Son();//����ת��
      base.method();//���ඪʧ��methodB����,���� base.methodB();�����
    //base.methodB();
      
      Son son=(Son)base;//����ת��,�����޴������޴�������Ҫǿ��ת��
      son.method();
      son.methodB();
      
      Base base2=new Base();
      Son son2=(Son) base2;//����ת�ͣ������޴������޴�
      son2.method();
      son2.methodB();
      
  }
}
*/





