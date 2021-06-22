package com.base.schedule.how2j.simpleTrigger;

import lombok.SneakyThrows;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * @author lryepoch
 * @date 2020/12/8 11:21
 * @description TODO 下一个8秒的倍数
 */
public class TestQuartz {

    @SneakyThrows
    public static void main(String[] args) {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

        //下一个8秒的倍数
        Date startTime = DateBuilder.nextGivenSecondDate(null, 8);
        JobDetail jobDetail = JobBuilder.newJob(MailJob.class).withIdentity("mailJob", "mailGroup").build();

        SimpleTrigger trigger = (SimpleTrigger) TriggerBuilder.newTrigger()
                .withIdentity("trigger1","group1")
                .startAt(startTime)
                .build();

        Date ft = scheduler.scheduleJob(jobDetail, trigger);

        System.out.println("当前时间是："+ new Date().toLocaleString());
        System.out.printf("%s 这个任务会在 %s 准时开始运行，累计运行 %d 次，间隔时间是 %d 毫秒 %n", jobDetail.getKey(),
                ft.toLocaleString(), trigger.getRepeatCount()+1, trigger.getRepeatInterval());

        scheduler.start();

        //等待200秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(200000);
        scheduler.shutdown(true);
    }
}
