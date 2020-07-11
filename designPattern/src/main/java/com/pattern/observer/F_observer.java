package com.pattern.observer;

public class F_observer extends Observer{
	public void update(String msg){
		//类名.class.getName()的作用是获取这个类的全类名
		System.out.println(F_observer.class.getName()+":"+msg);
		
	}

}
