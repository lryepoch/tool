package others;


/*import java.util.Scanner;

public class HelloWorld {

	public static void main(String[] args) {
		
		Scanner s=new Scanner(System.in);
		int a=s.nextInt();
		System.out.println(a);

		String b=s.nextLine();
		System.out.println(b);
		
	}

}*/



//二进制，或运算
/*
public class HelloWorld {
    public static void main(String[] args) {
         
        int i  =5;
        int j = 6;
         
        System.out.println(Integer.toBinaryString(i)); //5的二进制是101
         System.out.println(Integer.toBinaryString());
        System.out.println(Integer.toBinaryString(j)); //6的二进制是110
         
        System.out.println(i|j); //所以 5|6 对每一位进行或运算，得到 111->7
 
    }
}
*/



/*
public class HelloWorld{
	public static void main(String args[]){ 
		for(int i=0;i<10;i++){
			if(i%2==0){
				continue;
			}
			System.out.print(i+" ");
		}
	}
}
*/



/*
public class HelloWorld{
	public static void main(String args[]){
		for(int i=0;i<=100;i++){
			if(i%3==0||i%5==0){
				continue;
			}
			System.out.print(i+" ");
		}
	}
}
*/


/*
public class HelloWorld{
	public static void main(String args[]){ 
		for(int i=0;i<10;i++){
			if(i%2!=0)
				break;
			System.out.print(i+" ");
		}
	}
}
*/



//instance of
/*
public class HelloWorld{
	public static void main(String args[]){
		int i=5;
		Integer it=new Integer(i);
		//int i2=it.intValue();
		System.out.println(it instanceof Number);
	}
}*/


//Date的使用
/*import java.util.*;
public class HelloWorld{
	public static void main(String args[]){
		Date a=new Date();
		Date b=new Date(5000);
		System.out.println(a);
		System.out.println(b);
	}
}*/



//SimpleDateFormat的使用
/*
import java.text.SimpleDateFormat;
import java.util.Date;
public class HelloWorld{
	public static void main(String args[]){
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ");
		Date d=new Date();
		String  str=sdf.format(d);
		System.out.println(str);
	}
}
*/



/*public class HelloWorld {
    int i = 1; //属性名是i
    public void method1(int i){ //参数也是i
        System.out.println(i); 
    }
    
    public static void main(String[] args) {
		new HelloWorld().method1(5);
		//结果打印出来是 1还是5?
	}
}
*/


/*public class HelloWorld {
 
    public void method1(final int j) {
        j = 5; //这个能否执行？//no
    }
}*/


//import java.net.InetAddress;
//import java.net.UnknownHostException;
// 
//public class HelloWorld {
// 
//    public static void main(String[] args) throws UnknownHostException {
//        InetAddress host = InetAddress.getLocalHost();
//        String ip =host.getHostAddress();
//        System.out.println("本机ip地址：" + ip);
//    }
//}



/*public class HelloWorld {
  
    public static void main(String[] args) {
 
        //int的最大值
        System.out.println(Integer.MAX_VALUE);
        //int的最小值      
        System.out.println(Integer.MIN_VALUE);
          
    }
}
*/



//try……catch……finally。return
/*public class HelloWorld{
	
         public static int test(){
				try {
					System.out.println("try");
					return 1;
				} catch (Exception e) {
					System.out.println("catch");
					return 2;
				}finally
				{

				System.out.println("finally");
				return 3;
				}
	     }
         public static void main(String args[]){
        	HelloWorld.test();
         }
         
}*/



/*class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
     
}
class Employee extends Person {

	String empID = "0000";
	 
    public Employee(String nm) {
        super(nm);
        // TODO Auto-generated constructor stub
    }
 
}
public class HelloWorld {
    public static void main(String args[]) {
        Employee e = new Employee("123");
        System.out.println(e.empID);
    }
}*/



/*
class Person {
    String name = "No name";
    public Person(String nm) {
        name = nm;
    }
}
class Employee extends Person {
    String empID = "0000";
    public Employee(String id) {
    	super(id);
        empID = id;
    }
}
public class HelloWorld {
    public static void main(String args[]) {
        Employee e = new Employee("123567");
        System.out.println(e.empID);
    }
}
*/



/*
public class HelloWorld{
    String str = new String("hello");
    char[] ch = {'a','b','c'};
    public void fun(String str, char ch[]){
    str="world";
    ch[0]='d';
}
public static void main(String[] args) {
    HelloWorld test1 = new HelloWorld();
    test1.fun(test1.str,test1.ch);
    System.out.print(test1.str + " and ");
    System.out.print(test1.ch);
    }
}
*/



/*public class HelloWorld
{
    public static String output ="";
    public static void foo(int i)
    {
        try
        {
            if (i == 1)
            {
                throw new Exception();
            }
        }
        catch (Exception e)
        {
        	//e.printStackTrace();
            output += "2";
           return ;
        } finally
        {
            output += "3";
        }
        output += "4";
    }
    public static void main(String[] args)
    {
        foo(0);
        foo(1);
        System.out.println(output);
    }
}
*/


//Scanner的使用
/*
public class HelloWorld{
	public static void main(String[] args){
		Solution solution=new Solution();
		int[] nums=new int[4];
		Scanner sc=new Scanner(System.in);
		for(int k=0;k<nums.length;k++)
			nums[k]=sc.nextInt();
		
		int target=sc.nextInt();
		int[] is=solution.twoSum(nums, target);
		for(int i=0;i<is.length;i++)
		System.out.println("结果为"+is[i]);
	}
}
*/

//返回和等于某个数的2个数字
/*
class Solution{
	public int[] twoSum(int[] nums,int target){
		for(int i=0;i<nums.length;i++)
			for(int j=i+1;j<nums.length;j++)
				if(nums[i]+nums[j]==target)
					return new int[]{i,j};
	 //throw new IllegalArgumentException("No two sum solution");
		return new int[2];
	}
}

*/

//翻转
/*
public class HelloWorld {
    public static int reverse(int x) {
        String str = x +"";
        char[] arr = str.toCharArray();//将字符串对象中的字符转换为一个字符数组
        char[] resultArr = myReverse(arr, 0, arr.length - 1);
        String resultStr = new String(resultArr);
        return Integer.parseInt(resultStr);
    }
    
    public static char[] myReverse(char[] arr,int low,int high){
    	if(low<high){
    		char t = arr[low];
    		arr[low] = arr[high];
    		arr[high] = t;
    		return myReverse(arr, low+1, high-1);
    	} else {
    		return arr;
    	}
    }
    
    public static void main(String[] args){
    	int a = 12345678;
    	int b = 987654;
    	int c = 65647578;
    	int ar = reverse(a);
    	int br = reverse(b);
    	int cr = reverse(c);
    	System.out.println(a+"\n"+ar);
    	System.out.println(b+"\n"+br);
    	System.out.println(c+"\n"+cr);
    }
}*/

/*
class Solution {
    public int reverse(int x) {
        String str = x +"";
        char[] arr = str.toCharArray();
        char[] resultArr = myReverse(arr, 0, arr.length - 1);
        String resultStr = new String(resultArr);
        return Integer.parseInt(resultStr);
    }
    
    public char[] myReverse(char[] arr,int low,int high){
    	if(low<high){
    		char t = arr[low];
    		arr[low] = arr[high];
    		arr[high] = t;
    		return myReverse(arr, low+1, high-1);
    	} else {
    		return arr;
    	}
    }
}
*/


/*public class HelloWorld{
	public static void main(String[] args){
		int x=1;
		float y=2;
		System.out.println(x/y);
	}
}
*/

//回文数
//public class HelloWorld{
//	public static boolean isPalindrome(int x){
//		String str=x+"";
//		char[] g1=str.toCharArray();
//		boolean g2=reserve(g1,0,g1.length-1);
//		return g2;
//		
//	}
//	public static boolean reserve(char[] g , int low , int high){
//		boolean flag=true;
//		while(low<high){
//			if(g[low++]!=g[high--]){
//				flag=false;
//				//return flag;
//			}
//		}
//		return flag;
//	}
//	public static void main(String[] args){
//		Scanner sc=new Scanner(System.in);
//		int a=sc.nextInt();
//		if(true==isPalindrome(a))
//			System.out.println(a+"是回文数");
//		else System.out.println(a+"不是回文数");
//		
//	}
//}
