package schedule.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @author lryepoch
 * @date 2020/7/2 10:27
 * @description TODO Timer实例可以调度多个任务，且是线程安全的。TimerTask在run方法中实现具体的任务要求
 */
public class TestTimeOrder2 {
    public static void main(String[] args) {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + " 定时间隔3秒");
            }
        };

        Timer t = new Timer();
        long delay = 1000;
        long intevalTime = 3000;

        /**
         * scheduleAtFixedRate（task，time，period）
         * task-所要安排的任务
         * time-首次执行任务的时间
         * period-执行一次task的时间间隔，单位毫秒
         *
         * 作用：时间等于或超过time首次执行task，之后每隔period毫秒重复执行task
         *
         * */
        t.scheduleAtFixedRate(task, delay, intevalTime);
//        t.schedule(task,delay);
    }
}
