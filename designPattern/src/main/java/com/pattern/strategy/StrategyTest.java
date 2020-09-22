package com.pattern.strategy;

/**
 * 策略模式
 *
 * @author lryepoch
 * @description 创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。区分它们的只是他们直接的行为。
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
