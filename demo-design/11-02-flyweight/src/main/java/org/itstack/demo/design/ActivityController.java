package org.itstack.demo.design;

import org.itstack.demo.design.util.RedisUtils;

/**
 * @author lryepoch
 * @date 2021/1/12 13:57
 * @description 活动控制类
 *              在活动控制类中使用了享元工厂获取活动信息，查询后将库存信息在补充上。因为库存信息是变化的，而活动信息是固定不变的。
 *              最终通过统一的控制类就可以把完整包装后的活动信息返回给调用方。
 *
 */
public class ActivityController {

    private RedisUtils redisUtils = new RedisUtils();

    public Activity queryActivityInfo(Long id) {
        Activity activity = ActivityFactory.getActivity(id);
        // 模拟从Redis中获取库存变化信息
        Stock stock = new Stock(1000, redisUtils.getStockUsed());
        //设置库存信息
        activity.setStock(stock);
        return activity;
    }

}
