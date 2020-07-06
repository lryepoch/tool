package other;

import java.io.*;

public class Mathc {
	public static void main(String args[]){
		int x=0,y=0;
		double d=0.0;
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		try{
			System.out.println("输入x：");
			x=Integer.parseInt(br.readLine());
			System.out.println("输入y：");
			y=Integer.parseInt(br.readLine());
			System.out.println("输入d：");
			d=Double.parseDouble(br.readLine());
		}catch(IOException e){
			
		}
		System.out.println("x的y次方："+Math.pow(x, y));
		System.out.println("x和y的最大值："+Math.max(x, y));
		System.out.println("d的开方："+Math.sqrt(d));
		
		System.out.println("x的π："+Math.PI*2*x);
		System.out.println("x的π？？："+Math.PI*Math.pow(x, 2));
	}

}
