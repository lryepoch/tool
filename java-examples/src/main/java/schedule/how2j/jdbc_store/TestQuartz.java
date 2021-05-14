package schedule.how2j.jdbc_store;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import schedule.how2j.组成.MailJob;

/**
 * @author lryepoch
 * @date 2020/12/8 15:28
 * @description TODO 默认情况，Quartz的触发器，调度，任务等信息都是放在内存中的，叫做 RAMJobStore。
 * 好处是快速，坏处是一旦系统重启，那么信息就丢失了，就得全部从头来过。
 * 所以Quartz还提供了另一个方式，可以把这些信息存放在数据库，叫做 JobStoreTX。
 * 好处是就算系统重启了，目前运行到第几次了这些信息都是存放在数据库中的，那么就可以继续原来的步伐把计划任务无缝地继续做下去。
 * 坏处就是性能上比内存慢一些，毕竟数据库读取总是要慢一些的。
 */
public class TestQuartz {
    public static void main(String[] args) throws Exception {
        try {
            assignNewJob();
        } catch (ObjectAlreadyExistsException e) {
            System.err.println("发现任务已经在数据库存在了，直接从数据库里运行：" + e.getMessage());
            resumeJobFromDatabase();
        }
    }

    private static void resumeJobFromDatabase() throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        System.out.println("当前调度器的id是："+scheduler.getSchedulerInstanceId());
        scheduler.start();
        Thread.sleep(200000);
        scheduler.shutdown(true);
    }

    private static void assignNewJob() throws Exception{
        // 创建调度器
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        // 定义一个触发器
        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "group1") // 定义名称和所属的租
                .startNow()
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(15) // 每隔15秒执行一次
                        .withRepeatCount(10)) // 总共执行11次(第一次执行不基数)
                .build();

        // 定义一个JobDetail
        JobDetail jobDetail = JobBuilder.newJob(MailJob.class) //指定干活的类MailJob
                .withIdentity("mailjob1", "mailgroup") //定义任务名称和分组
                .usingJobData("email", "admin@10086.com") //定义属性
                .build();

        // 调度加入这个job
        scheduler.scheduleJob(jobDetail, trigger);

        // 启动
        scheduler.start();

        // 等待20秒，让前面的任务都执行完了之后，再关闭调度器
        Thread.sleep(20000);
        scheduler.shutdown(true);
    }
}
