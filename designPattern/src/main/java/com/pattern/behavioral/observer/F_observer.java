package com.pattern.behavioral.observer;

public class F_observer extends Observer{
	public void update(String msg){
		//����.class.getName()�������ǻ�ȡ������ȫ����
		System.out.println(F_observer.class.getName()+":"+msg);
		
	}

}
