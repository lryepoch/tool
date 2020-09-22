package com.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

//��Ϊ���۲��ߣ���Ŀ��
public class Subject {
	private List<Observer> observers= new ArrayList<Observer>();//״̬�ĸı�
	
	//��ӹ۲��߶��󣬼�ע����
	public void addAttach(Observer observer){
		observers.add(observer);//add����Ϊarraylist���ϵķ���
	}

	//��Ŀ�귢���ı�ʱ��
	public void setMsg(String msg){
		//֪ͨ
		notifyAll(msg);
	}
	
	//֪ͨ�ڴ�ע��Ķ�����
	private void notifyAll(String msg) {
		for(Observer observer:observers){
			observer.update(msg);
		}
		
	}

}
