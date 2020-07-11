package com.pattern.singleton;

import java.util.concurrent.ThreadFactory;

public class SingleObject {
	
	//饿汉式
//	private static SingleObject singleObject=new SingleObject();
	
//	private SingleObject(){
//		
//	}
	
//	public static SingleObject getInstance(){
//		return singleObject;
//		
//	}
	
	public void showMessage(){
		System.out.println(Thread.currentThread().getId());
	}



//双重校验锁
//	private volatile static SingleObject singleObject;
	
//	private SingleObject(){
//		
//	}
	
//	public static SingleObject getInstance(){
	
//		if(singleObject==null){
//			synchronized (SingleObject.class) {
//				if(singleObject==null)
//					singleObject=new SingleObject();
//			}
//		}
//		return singleObject;
//	}



	//懒汉式
	private static SingleObject singleObject;
	
	private SingleObject(){
		
	}
	public static SingleObject getInstance(){
		
		if(singleObject == null){
			
			singleObject = new SingleObject();
			
		}
		return singleObject;
		
	}

}
