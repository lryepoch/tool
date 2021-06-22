package com.base.base;

public class substring {
	public static void main(String[] args) {
		
		//字符切割
		String string="1234567";
		String a="123";
		String aString =string.substring(1,4);
		System.out.println(aString);
		System.out.println(string.contains(a));
		
		//字符串数组
		String str[]={"AAA","BBB","CCC"};
		for (String string2 : str) {
			System.out.println(string2);
		}
		
	}

}
