package schedule.how2j.simpleTrigger;

import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lryepoch
 * @date 2020/12/8 11:21
 * @description TODO
 */
public class MailJob implements Job {

    @SneakyThrows
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        JobDetail detail = jobExecutionContext.getJobDetail();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String now = sdf.format(new Date());

        System.out.printf("发出了一封邮件，当前时间是：%s%n", now);
        Thread.sleep(10000);
    }
}
