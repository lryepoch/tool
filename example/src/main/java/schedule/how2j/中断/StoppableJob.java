package schedule.how2j.中断;

import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;

/**
 * @author lryepoch
 * @date 2020/12/8 10:03
 * @description TODO
 */
public class StoppableJob implements InterruptableJob {
    private boolean stop = false;

    @Override
    public void interrupt() {
        System.out.println("被调度叫停");
        stop = true;
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) {
        while (true) {
            if (stop) {
                break;
            }
            try {
                System.out.println("每隔一秒，进行一次检测，看看是否停止");
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("持续工作中……");
        }
    }
}
