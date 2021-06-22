package com.base.base;

import java.util.HashMap;

/**
* hashcode() equals()
*/
public class People {
	private String name;
	private int age;
	
	public People(String name,int age){
		this.name=name;
		this.age=age;
	}
	public void setAge(int age){
		this.age=age;
	}
	
	//覆盖object的hashcode方法
	@Override
	public int hashCode() {
		return name.hashCode()*37+age;
	}
	
	//覆盖object的equals方法
	@Override
	public boolean equals(Object obj){
		return this.name.equals(((People)obj).name) && this.age==((People)obj).age;
	}

	public static void main(String[] args) {
		
		People p1 = new People("Jack", 12);
		System.out.println(p1.hashCode());
		
		HashMap<People, Integer> hashMap = new HashMap<People, Integer>();
		hashMap.put(p1, 1);
		p1.setAge(13);
		System.out.println(hashMap.get(p1));
	}

}
