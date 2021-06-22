package com.base.base;

class Man {
	private String name=null;
	private boolean sex;
	private long num=0;
	
	public Man(String name1){
		name=name1;
	}
	public Man(boolean sex1){
		sex=sex1;
	}
	public Man(long num1){
		num=num1;
	}
	
	void modifyName(String name1){
		name=name1;
		
	}  //???????
	
	void modifySex(boolean b){
		  sex=b;
	  }//??????
	
	void modefyNum(long no){
		  num=no;
	  } 
	  
	String getName(){
		return name;
	}              //???????
	
	boolean getSex(){
		  return sex;
	  }               //??????
	
	long getNum(){
		  return num;
	}
	
}
public class CreateMan{
	public static void main(String args[]){
		Man man1=new Man("jxy");
		man1.modefyNum(12);
		man1.modifySex(true);
		System.out.println("????"+man1.getName()+"\n"
				+"???"+man1.getNum()+"\n"
				+"???"+man1.getSex()+"\n");
		
	}
}
