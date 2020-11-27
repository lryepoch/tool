package thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author lryepoch
 * @date 2020/11/27 14:19
 * @description TODO
 */
public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //创建线程池对象
        ExecutorService threadPool= Executors.newFixedThreadPool(2);
        //创建一个callable接口子类对象
        MyCallable c1=new MyCallable(1,2);
        MyCallable c2=new MyCallable(100,200);

        //获取线程池中的线程，调用callable接口子类对象中的call（）方法，完成求和操作，Future对象封装callable对象返回的结果
        Future<Integer> result=threadPool.submit(c1);
        //从结果中获取对应的值
        Integer sum=result.get();
        //输出值到控制台
        System.out.println(sum);
        //从线程池中获取线程，并执行call()方法，完成求和操作，封装返回结果
        result=threadPool.submit(c2);
        //从结果中获取对应的值
        Integer sum2=result.get();
        //打印到控制台
        System.out.println(sum2);

    }
}
