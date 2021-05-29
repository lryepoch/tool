package org.itstack.demo.design;

import org.itstack.demo.design.event.EventManager;
import org.itstack.demo.design.event.listener.MQEventListener;
import org.itstack.demo.design.event.listener.MessageEventListener;

/**
 * @author lryepoch
 * @date 2021/1/12 11:11
 * @description 业务抽象类接口
 */
public abstract class LotteryService {

    private EventManager eventManager;

    /**
     * @author lryepoch
     * @date 2021/1/12 11:18
     * @description 构造方法初始化订阅事件
     */
    public LotteryService() {
        eventManager = new EventManager(EventManager.EventType.MQ, EventManager.EventType.Message);
        eventManager.subscribe(EventManager.EventType.MQ, new MQEventListener());
        eventManager.subscribe(EventManager.EventType.Message, new MessageEventListener());
    }

    public LotteryResult draw(String uId) {
        LotteryResult lotteryResult = doDraw(uId);
        // 需要什么通知就给调用什么方法
        eventManager.notify(EventManager.EventType.MQ, lotteryResult);
        eventManager.notify(EventManager.EventType.Message, lotteryResult);
        return lotteryResult;
    }

    protected abstract LotteryResult doDraw(String uId);

}
