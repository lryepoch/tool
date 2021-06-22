package com.base.schedule.how2j.listener;

import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.matchers.KeyMatcher;
import com.base.schedule.how2j.组成.MailJob;

/**
 * @author lryepoch
 * @date 2020/12/8 15:14
 * @description TODO Quartz 的监听器有Job监听器，Trigger监听器， Scheduler监听器，对不同层面进行监控。
 *                          实际业务用的较多的是Job监听器，用于监听器是否执行了，其他的用的相对较少
 */
public class TestQuartz {
    @SneakyThrows
    public static void main(String[] args) {
        //创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //定义一个触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") //定义名称和所属的租
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(2) //每隔2秒执行一次
                        .withRepeatCount(10)) //总共执行11次(第一次执行不基数)
                .build();

        //定义一个JobDetail
        JobDetail mailJob = JobBuilder.newJob(MailJob.class) //指定干活的类MailJob
                .withIdentity("mailjob1", "mailgroup") //定义任务名称和分组
                .usingJobData("email", "admin@10086.com") //定义属性
                .build();

        //增加job监听
        MailJobListener mailJobListener = new MailJobListener();
        KeyMatcher<JobKey> keyMatcher = KeyMatcher.keyEquals(mailJob.getKey());
        scheduler.getListenerManager().addJobListener(mailJobListener, keyMatcher);

        //调度加入这个job
        scheduler.scheduleJob(mailJob, trigger);

        //启动
        scheduler.start();

        //等待20秒，让前面的任务都执行完了之后，在关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown(true);

    }
}
