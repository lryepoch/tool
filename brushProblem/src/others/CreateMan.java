package others;

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
		
	}  //修改姓名
	void modifySex(boolean b){
		  sex=b;
	  }//修改性别
	void modefyNum(long no){
		  num=no;
	  } 
	String getName(){
		return name;
	}              //取得姓名
	boolean getSex(){
		  return sex;
	  }               //取得性别
	long getNum(){
		  return num;
	}
	
}
public class CreateMan{
	public static void main(String args[]){
		Man man1=new Man("jxy");
		man1.modefyNum(12);
		man1.modifySex(true);
		System.out.println("姓名"+man1.getName()+"\n"
				+"学号"+man1.getNum()+"\n"
				+"性别"+man1.getSex()+"\n");
		
	}
}
