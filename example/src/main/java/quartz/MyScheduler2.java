package quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author lryepoch
 * @date 2020/7/1 18:59
 * @description TODO
 */
public class MyScheduler2 {
    public static void main(String[] args) throws SchedulerException {
        //1.创建调度器Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        //2.创建JobDetail实例，并与PrintWordsJob类绑定（Job执行内容）
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .usingJobData("jobDetail1","这个job用来测试的")
                .withIdentity("job1","group1").build();

        //3.构建Trigger实例，每隔1s执行了一次
        Date startDate = new Date();
        startDate.setTime(startDate.getTime()+5000);

        Date endDate = new Date();
        endDate.setTime(startDate.getTime()+5000);

        CronTrigger cronTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1","triggerGroup1")
                .usingJobData("trigger1","这是jobDetail1的trigger")
                .startNow()//立即生效
                .startAt(startDate)
                .endAt(endDate)
                .withSchedule(CronScheduleBuilder.cronSchedule("* 25 19 ? * 1/5 2020"))
                .build();

        //4.执行
        scheduler.scheduleJob(jobDetail,cronTrigger);
        System.out.println("-------start------");
        scheduler.start();
        System.out.println("------shutdown----");

    }
}
