package org.itstack.demo.design.event.listener;

import org.itstack.demo.design.LotteryResult;

/**
 * @author lryepoch
 * @date 2021/1/12 10:49
 * @description 事件监听接口定义
 *              接口中定义了基本的事件类，这里如果方法的入参信息类型是变化的可以使用泛型<T>
 */
public interface EventListener {

    void doEvent(LotteryResult result);

}
