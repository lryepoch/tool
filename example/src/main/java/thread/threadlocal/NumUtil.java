package thread.threadlocal;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author lryepoch
 * @date 2020/12/1 9:31
 * @description TODO
 */
public class NumUtil {

    /**
     * @author lryepoch
     * @date 2020/12/1 9:31
     * @description 有问题
     */
    public static int addNum = 0;

    public static int add10(int num) {
        addNum = num;
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return addNum + 10;
    }

    /**
     * @description ThreadLocal的使用
     * @author lryepoch
     * @date 2020/12/1 9:44
     */
    private static ThreadLocal<Integer> addNumThreadLocal = new ThreadLocal<>();

    public static int add10to(int num) {
        addNumThreadLocal.set(num);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int a = addNumThreadLocal.get() + 10;
        return a;
    }

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 20; i++) {
            int num = i;
            service.execute(() -> {
                System.out.println(num + " " + NumUtil.add10to(num));
            });
        }
        service.shutdown();
    }

}
