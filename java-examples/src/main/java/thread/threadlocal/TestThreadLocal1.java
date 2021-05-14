package thread.threadlocal;

/**
 * @author lryepoch
 * @date 2020/12/3 16:57
 * @description TODO 开启三个新的线程，每个线程对数据进行累加。每个线程的值都是1~5进行递增，没有出现混加。这就实现了每个线程之间的数据的隔离。
 */
public class TestThreadLocal1 {

    //线程本地存储变量
    private static final ThreadLocal<Integer> THREAD_LOCAL_NUM = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

    /**
     * 线程本地存储变量加 5
     */
    private static void add10ByThreadLocal() {
        for (int i = 0; i < 5; i++) {
            Integer n = THREAD_LOCAL_NUM.get();
            n += 1;
            THREAD_LOCAL_NUM.set(n);
            System.out.println(Thread.currentThread().getName() + " : ThreadLocal num=" + n);
        }
    }

    public static void main(String[] args) {
        //启动三个线程
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread() {
                @Override
                public void run() {
                    add10ByThreadLocal();
                }
            };
            t.start();
        }
    }
}
