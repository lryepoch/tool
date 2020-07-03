package timed_task;

/**
 * @author lryepoch
 * @date 2020/7/2 10:22
 * @description TODO thread + while + sleep 实现定时功能
 */
public class TestTimeOrder {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        final long timeInterval = 3000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println(Thread.currentThread().getName() + " 定时间隔3秒");
                    try {
                        Thread.sleep(timeInterval);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}
