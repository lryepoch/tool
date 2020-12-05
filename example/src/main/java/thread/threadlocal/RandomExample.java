package thread.threadlocal;

/**
 * @author lryepoch
 * @date 2020/11/30 9:57
 * @description TODO
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
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread2.start();
    }
}
