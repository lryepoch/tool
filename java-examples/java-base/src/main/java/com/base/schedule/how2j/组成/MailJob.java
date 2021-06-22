package com.base.schedule.how2j.组成;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author lryepoch
 * @date 2020/12/7 14:11
 * @description TODO MailJob实现了Job接口，提供 execute，干具体的活儿
 */
@DisallowConcurrentExecution
public class MailJob implements Job {
    @Override
    public void execute(JobExecutionContext context) {
        JobDetail detail = context.getJobDetail();
        String email = detail.getJobDataMap().getString("email");

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String now = sdf.format(new Date());

        System.out.printf("给邮件地址 %s 发出了一封定时邮件，当前时间是：%s%n", email, now);
    }

}