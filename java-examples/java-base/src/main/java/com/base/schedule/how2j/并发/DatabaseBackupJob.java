package com.base.schedule.how2j.并发;

import org.quartz.*;

/**
 * @author lryepoch
 * @date 2020/12/7 17:03
 * @description TODO
 */
@DisallowConcurrentExecution
public class DatabaseBackupJob implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        JobDetail detail = context.getJobDetail();
        String database = detail.getJobDataMap().getString("database");
        System.out.printf("给数据库%s备份，耗时10秒%n", database);
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
