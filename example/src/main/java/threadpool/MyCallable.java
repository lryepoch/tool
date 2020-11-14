package threadpool;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer>{
	//初始变量
	int x=2;
	int y=3;
	//构造方法
	public MyCallable(){
		
	}
	public MyCallable(int x,int y){
		this.x=x;
		this.y=y;
	}
	@Override
	public Integer call() throws Exception{
		return x+y;
	}
	

}
