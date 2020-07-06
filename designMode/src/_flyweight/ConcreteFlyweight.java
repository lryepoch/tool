package _flyweight;

////具体享元角色类
public class ConcreteFlyweight implements Flyweight {
	private String string;//内蕴状态
	  /**
     * 构造函数，内蕴状态作为参数传入
     * 
     * @param intrinsicState
     */
	public ConcreteFlyweight(String string){
		this.string=string;
	}
	
	 /**
     * 外蕴状态作为参数传入方法中，改变方法的行为， 但是并不改变对象的内蕴状态。
     */
	public void operation(String state) {
		// TODO Auto-generated method stub
		System.out.println("内蕴状态:"+this.string);
		System.out.println("外蕴状态："+state);

	}

}
