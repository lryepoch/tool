package thread.threadlocal;

/**
 * @author lryepoch
 * @date 2020/11/30 9:57
 * @description TODO 两个线程共享一个MyRunnable实例。
 *                   每个线程执行run()方法的时候，会给同一个ThreadLocal实例设置不同的值。如果调用set()方法的时候用synchronized关键字同步，
 *                   而且不是一个ThreadLocal对象实例，那么第二个线程将会覆盖第一个线程所设置的值。
 */
public class RandomExample {

    public static class MyRunnable implements Runnable {

        private ThreadLocal<Integer> threadLocal = new ThreadLocal();

        @Override
        public void run() {
            int number = (int) (Math.random() * 100D);
            System.out.println(Thread.currentThread().getName() + " 产生随机数：" + number);
            threadLocal.set(number);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +" 中当前threadlocal保存的值：" + threadLocal.get());
        }
    }

    public static void main(String[] args) {
        //线程任务
        MyRunnable sharedRunnableInstance = new MyRunnable();
        //线程对象thread1/thread2
        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
    }
}
