package schedule.timer;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author lryepoch
 * @date 2020/7/2 10:55
 * @description TODO 通过线程池来执行任务实现
 */
public class TestTimeOrder3 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" 定时时间间隔3秒");
            }
        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();

        // 第二个参数为首次执行的延时时间，第三个参数为定时执行的间隔时间
        service.scheduleAtFixedRate(runnable,1000L,3000L, TimeUnit.MILLISECONDS);
    }
}
