package com.base.schedule.how2j.组成;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author lryepoch
 * @date 2020/12/7 16:37
 * @description TODO Job组成部分
 */
public class TestQuartz1 {
    public static void main(String[] args) throws Exception {
        jobDataMap();
    }

    private static void jobDataMap() throws SchedulerException, InterruptedException {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1","group1")
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(2)
                    .withRepeatCount(10))
                .build();

        //定义一个JobDetail
        JobDetail jobDetail = JobBuilder.newJob(MailJob.class)
                .withIdentity("mailjob1", "mailgroup")
                .usingJobData("email", "admin@10086.com")
                .build();

        //用JobDataMap修改email
        jobDetail.getJobDataMap().put("email","admin@taobao.com");

        //调度加入这个job
        scheduler.scheduleJob(jobDetail, trigger);

        //启动
        scheduler.start();

        //等待20秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown();

    }
}
