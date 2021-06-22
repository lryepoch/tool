package com.base.schedule.how2j.exception;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author lryepoch
 * @date 2020/12/7 20:09
 * @description TODO
 */
public class ExceptionJob2 implements Job {

    static int i=0;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        try {
            //故意发生异常
            System.out.println("运算结果："+100/i);

        } catch (Exception e) {
            System.out.println("发生了异常，修改一下参数，立即重新执行");

            i = 1;
            JobExecutionException je =new JobExecutionException(e);
            je.setRefireImmediately(true);

            throw je;
        }
    }

}
