package com.pattern.observer;

/**
 * 观察者模式
 *
 * @author lryepoch
 * @description 当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新。
 * @date 2020/7/7 10:17
 */
public class ObserverTest {

    public static void main(String[] args) {

        F_observer f_observer = new F_observer();
        S_observer s_observer = new S_observer();
        T_Observer t_Observer = new T_Observer();

        Subject subject = new Subject();

        //观察者注册到被观察者中。
        subject.addAttach(f_observer);
        subject.addAttach(s_observer);
        subject.addAttach(t_Observer);

        //目标变化，通知观察者
        subject.setMsg("msg change");
        subject.setMsg("hahhhhhhhhhh");

    }

}
