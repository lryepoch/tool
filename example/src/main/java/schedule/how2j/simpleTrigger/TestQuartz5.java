package schedule.how2j.simpleTrigger;

import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

import static org.quartz.CronScheduleBuilder.cronSchedule;

/**
 * @author lryepoch
 * @date 2020/12/8 14:18
 * @description TODO CronTrigger 就是用 Cron 表达式来安排触发时间和次数的。
 *
 *
 * 由7个部分组成，每个部分就如图所示分别对应：秒 分 时 日 月 星期 年(可选)
 *
 * 星号(*)：可用在所有字段中，表示对应时间域的每一个时刻，例如， 在分钟字段时，表示“每分钟”；
 * 问号（?）：该字符只在日期和星期字段中使用，它通常指定为“无意义的值”，相当于点位符；
 * 减号(-)：表达一个范围，如在小时字段中使用“10-12”，则表示从10到12点，即10,11,12；
 * 逗号(,)：表达一个列表值，如在星期字段中使用“MON,WED,FRI”，则表示星期一，星期三和星期五；
 *
 *
 */
public class TestQuartz5 {
    @SneakyThrows
    public static void main(String[] args) {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Date startTime = DateBuilder.nextGivenSecondDate(null, 8);

        JobDetail jobDetail = JobBuilder.newJob(MailJob.class)
                .withIdentity("mailJob", "mailGroup")
                .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/2 * * * * ?"))
                .build();

        // schedule it to run!
        Date ft = scheduler.scheduleJob(jobDetail, trigger);

        System.out.println("使用的Cron表达式是：" + trigger.getCronExpression());
//            System.out.printf("%s 这个任务会在 %s 准时开始运行，累计运行%d次，间隔时间是%d毫秒%n", job.getKey(), ft.toLocaleString(), trigger.getRepeatCount()+1, trigger.getRepeatInterval());

        scheduler.start();

        //等待200秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(200000);
        scheduler.shutdown(true);
    }
}
