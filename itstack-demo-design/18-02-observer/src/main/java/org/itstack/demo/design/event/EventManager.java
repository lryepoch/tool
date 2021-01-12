package org.itstack.demo.design.event;

import org.itstack.demo.design.LotteryResult;
import org.itstack.demo.design.event.listener.EventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lryepoch
 * @date 2021/1/12 10:50
 * @description 事件处理类
 *              整个处理的实现上提供了三个主要方法；订阅(subscribe)、取消订阅(unsubscribe)、通知(notify)。这三个方法分别用于对监听时间的添加和使用。
 *              另外因为事件有不同的类型，这里使用了枚举的方式进行处理，也方便让外部在规定下使用事件，而不至于乱传信息(EventType.MQ、EventType.Message)。
 *
 */
public class EventManager {

    Map<Enum<EventType>, List<EventListener>> listeners = new HashMap<>();

    //    ...表示可变长参数，就是说这个位置可以传入任意个该类型参数，简单来说就是个数组。
    public EventManager(Enum<EventType>... operations) {
        for (Enum<EventType> operation : operations) {
            this.listeners.put(operation, new ArrayList<>());
        }
    }

    public enum EventType {
        MQ, Message
    }

    /**
     * 订阅
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void subscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.add(listener);
    }

    /**
     * 取消订阅
     * @param eventType 事件类型
     * @param listener  监听
     */
    public void unsubscribe(Enum<EventType> eventType, EventListener listener) {
        List<EventListener> users = listeners.get(eventType);
        users.remove(listener);
    }

    /**
     * 通知
     * @param eventType 事件类型
     * @param result    结果
     */
    public void notify(Enum<EventType> eventType, LotteryResult result) {
        List<EventListener> users = listeners.get(eventType);
        for (EventListener listener : users) {
            listener.doEvent(result);
        }
    }

}
