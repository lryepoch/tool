package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.Activity;
import org.itstack.demo.design.ActivityController;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**         「基于Redis秒杀，提供活动与库存信息查询场景」
 * @author lryepoch
 * @date 2021/1/12 13:51
 * @description 享元模式，主要在于共享通用对象，减少内存的使用，提升系统的访问效率。而这部分共享对象通常比较耗费内存或者需要查询大量接口或者使用数据库资源，
 *              因此统一抽离作为共享对象使用。
 *              在享元模型的实现中需要使用到享元工厂来进行管理这部分独立的对象和共享的对象，避免出现线程安全的问题。
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    private ActivityController activityController = new ActivityController();

    @Test
    public void test_queryActivityInfo() throws InterruptedException {
        for (int idx = 0; idx < 10; idx++) {
            Long req = 10001L;
            Activity activity = activityController.queryActivityInfo(req);
            logger.info("测试结果：{} {}", req, JSON.toJSONString(activity));
            Thread.sleep(1200);
        }
    }

}
