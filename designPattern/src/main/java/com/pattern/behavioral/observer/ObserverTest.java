package com.pattern.behavioral.observer;

/**
 * �۲���ģʽ
 *
 * @author lryepoch
 * @description ��һ�������״̬�����ı�ʱ���������������Ķ��󶼵õ�֪ͨ�����Զ����¡�
 * @date 2020/7/7 10:17
 */
public class ObserverTest {

    public static void main(String[] args) {

        F_observer f_observer = new F_observer();
        S_observer s_observer = new S_observer();
        T_Observer t_Observer = new T_Observer();

        Subject subject = new Subject();

        //�۲���ע�ᵽ���۲����С�
        subject.addAttach(f_observer);
        subject.addAttach(s_observer);
        subject.addAttach(t_Observer);

        //Ŀ��仯��֪ͨ�۲���
        subject.setMsg("msg change");
        subject.setMsg("hahhhhhhhhhh");

    }

}
