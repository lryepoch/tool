package com.pattern.observer;

public class T_Observer extends Observer {

	@Override
	public void update(String msg) {
		System.out.println(T_Observer.class.getName()+":"+msg);
	}

}
