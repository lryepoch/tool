package com.pattern.behavioral.strategy;

/**
 * ����ģʽ
 *
 * @author lryepoch
 * @description ������ʾ���ֲ��ԵĶ����һ����Ϊ���Ų��Զ���ı���ı�� context �����������ǵ�ֻ������ֱ�ӵ���Ϊ��
 * @date 2020/7/7 11:08
 */
public class StrategyTest {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(10, 5));

        context = new Context(new OperationSubstract());
        System.out.println(context.executeStrategy(10, 5));

        context = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(10, 5));
    }

}
