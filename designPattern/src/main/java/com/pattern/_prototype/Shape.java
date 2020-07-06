package _prototype;

//shape实现cloneable接口
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
	
	//要区分浅复制和深复制的区别
	public Object clone(){
		Object clone = null;
		try {
			//调用父类clone方法，实现克隆
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return clone;
	}

}
