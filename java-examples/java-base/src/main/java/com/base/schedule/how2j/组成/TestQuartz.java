package com.base.schedule.how2j.组成;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lryepoch
 * @date 2020/12/7 14:07
 * @description TODO quartz入门
 */
public class TestQuartz {
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        //创建一个调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //定义一个触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        //每隔两秒执行一次
                        .withIntervalInSeconds(2)
                        //总共执行11次（第一次执行不计数）
                        .withRepeatCount(10))
                .build();

        //定义一个JobDetail
        //指定干活的类MailJob
        JobDetail job = JobBuilder.newJob(MailJob.class)
                //定义任务名称和分组
                //mailgroup 就是分组的意思
                //比如一个系统有3个job 是备份数据库的，有4个job 是发邮件的，那么对他们进行分组，可以方便管理，类似于一次性停止所有发邮件的这样的操作.
                .withIdentity("mailjob1", "mailgroup")
                //定义属性
                .usingJobData("email", "admin@10086.com")
                .build();

        //调度加入这个job
        scheduler.scheduleJob(job, trigger);

        //启动
        scheduler.start();

        //等待20秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown();
    }
}
