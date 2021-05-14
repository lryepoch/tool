package schedule.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.concurrent.TimeUnit;

/**
 * @author lryepoch
 * @date 2020/7/1 15:58
 * @description TODO
 */
public class MyScheduler {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        /*1.创建调度器Scheduler*/
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        /*2.创建JobDetail实例，并与PrintWordsJob类绑定（Job执行内容）*/
        JobDetail jobDetail = JobBuilder.newJob(PrintWordsJob.class)
                .withIdentity("job1","group1")
                .build();

        //3.构建Trigger实例，每隔1s执行一次
        Trigger trigger =TriggerBuilder.newTrigger()
                //定义名称和所属的组
                .withIdentity("trigger1","triggerGroup1")
                .startNow()//立即生效
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                .withIntervalInSeconds(1)//每隔1s执行一次
                .repeatForever())
                .build();//一直执行

        //4.执行
        scheduler.scheduleJob(jobDetail, trigger);
        System.out.println("-------scheduler start!-----");
        scheduler.start();

        //5.睡眠，1min
        TimeUnit.SECONDS.sleep(10);
        scheduler.shutdown();
        System.out.println("---------scheduler shutdown!---------");
    }
}
