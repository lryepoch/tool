package org.itstack.demo.design;

import java.util.Date;

/**
 * @author lryepoch
 * @date 2021/1/12 13:49
 * @description 模拟的是从接口中查询活动信息，基本也就是从数据库中获取所有的商品信息和库存
 */
public class ActivityController {

    public Activity queryActivityInfo(Long id) {
        // 模拟从实际业务应用从接口中获取活动信息
        Activity activity = new Activity();
        activity.setId(10001L);
        activity.setName("图书嗨乐");
        activity.setDesc("图书优惠券分享激励分享活动第二期");
        activity.setStartTime(new Date());
        activity.setStopTime(new Date());
        activity.setStock(new Stock(1000,1));
        return activity;
    }

}
