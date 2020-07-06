package threadpool;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolDemo {

	public static void main(String[] args) throws InterruptedException,ExecutionException{
		//�����̳߳ض���
		ExecutorService threadPool=Executors.newFixedThreadPool(2);
		//����һ��callable�ӿ��������
		MyCallable c1=new MyCallable(1,2);
		MyCallable c2=new MyCallable(100,200);
		
		//��ȡ�̳߳��е��̣߳�����callable�ӿ���������е�call���������������Ͳ�����Future�����װcallable���󷵻صĽ��
		Future<Integer> result=threadPool.submit(c1);
		//�ӽ���л�ȡ��Ӧ��ֵ
		Integer sum=result.get();
		//���ֵ������̨
		System.out.println(sum);
		//���̳߳��л�ȡ�̣߳���ִ��call()�����������Ͳ�������װ���ؽ��
		result=threadPool.submit(c2);
		//�ӽ���л�ȡ��Ӧ��ֵ
		Integer sum2=result.get();
		//��ӡ������̨
		System.out.println(sum2);
		


		

	}

}
