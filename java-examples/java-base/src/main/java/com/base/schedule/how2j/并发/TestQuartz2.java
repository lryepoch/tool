package com.base.schedule.how2j.并发;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lryepoch
 * @date 2020/12/7 17:14
 * @description TODO Job 并发
 */
public class TestQuartz2 {
    public static void main(String[] args) throws InterruptedException, SchedulerException {
        databaseCurrentJob();
    }

    private static void databaseCurrentJob() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2)
                        .withRepeatCount(10))
                .build();

        //定义一个JobDetail
        JobDetail job = JobBuilder.newJob(DatabaseBackupJob.class)
                .withIdentity("backupjob", "databasegroup")
                .usingJobData("database", "how2java")
                .build();

        //调度加入这个job
        scheduler.scheduleJob(job, trigger);

        //启动
        scheduler.start();

        //等待200秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(200000);
        scheduler.shutdown(true);
    }
}
