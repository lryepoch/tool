package com.pattern.creational.prototype;

//shapeʵ��cloneable�ӿ�
public abstract class Shape implements Cloneable {
	
	private String id;
	protected String type;
	
	abstract void draw();
	
	public String getType(){
		return type;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id=id;
	}
	
	//Ҫ����ǳ���ƺ���Ƶ�����
	public Object clone(){
		Object clone = null;
		try {
			//���ø���clone������ʵ�ֿ�¡
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return clone;
	}

}
