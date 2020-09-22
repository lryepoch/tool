package com.pattern.observer;

import java.util.ArrayList;
import java.util.List;

//此为被观察者，即目标
public class Subject {
	private List<Observer> observers= new ArrayList<Observer>();//状态的改变
	
	//添加观察者对象，即注册先
	public void addAttach(Observer observer){
		observers.add(observer);//add（）为arraylist集合的方法
	}

	//当目标发生改变时，
	public void setMsg(String msg){
		//通知
		notifyAll(msg);
	}
	
	//通知在此注册的对象们
	private void notifyAll(String msg) {
		for(Observer observer:observers){
			observer.update(msg);
		}
		
	}

}
