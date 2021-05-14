package schedule.how2j.exception;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author lryepoch
 * @date 2020/12/7 20:09
 * @description TODO 故意发生异常1
 */
public class ExceptionJob1 implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        int i = 0;
        try {
            System.out.println("运算结果：" + 100 / i);
        } catch (Exception e) {
            System.out.println("发生了异常，取消这个Job对应的所有调度");

            JobExecutionException je = new JobExecutionException(e);
            je.setUnscheduleAllTriggers(true);

            throw je;
        }
    }
}
