package com.pattern.structural.flyweight;

import java.util.Hashtable;

//��Ԫ������ɫ��
public class FlyweightFactory {

    //һ��������������Ԫ����ļ���String��ʾ����ļ������� ->����״̬��Flyweight��ʾ����ֵ������
    private Hashtable<String, Flyweight> flyweight = new Hashtable<>();

    public Flyweight getFlyweight(String obj) {
        //�ȴӻ����в��Ҷ���
        Flyweight fly = flyweight.get(obj);

        if (fly == null) {
            // ������󲻴����򴴽�һ���µ�Flyweight����
            fly = new ConcreteFlyweight(obj);
            // ������µ�Flyweight������ӵ�������
            flyweight.put(obj, fly);
        }
        return fly;
    }

    //�õ������ļ��ϵĳ���
    public int getFlyweightSize() {
        return flyweight.size();
    }

}
