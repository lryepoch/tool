package com.pattern.structural.flyweight;

/**
 * @author lryepoch
 * @description ������Ԫ��ɫ��
 * @date 2020/7/7 9:16
 */
public class ConcreteFlyweight implements Flyweight {

    private String string;//����״̬

    /**
     * ���캯��������״̬��Ϊ��������
     */
    public ConcreteFlyweight(String string) {
        this.string = string;
    }

    /**
     * ����״̬��Ϊ�������뷽���У��ı䷽������Ϊ�����ǲ����ı���������״̬
     * 
     */
    public void operation(String state) {

        System.out.println("����״̬:" + this.string);
        System.out.println("����״̬��" + state);

    }

}
