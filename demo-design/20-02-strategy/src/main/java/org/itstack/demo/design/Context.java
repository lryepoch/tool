package org.itstack.demo.design;

import java.math.BigDecimal;

/**
 * @author lryepoch
 * @date 2021/1/12 15:04
 * @description 策略控制类
 *              策略模式的控制类主要是外部可以传递不同的策略实现，在通过统一的方法执行优惠策略计算。
 *              另外这里也可以包装成map结构，让外部只需要对应的泛型类型即可使用相应的服务。
 */
public class Context<T> {

    private ICouponDiscount<T> couponDiscount;

    public Context(ICouponDiscount<T> couponDiscount) {
        this.couponDiscount = couponDiscount;
    }

    public BigDecimal discountAmount(T couponInfo, BigDecimal skuPrice) {
        return couponDiscount.discountAmount(couponInfo, skuPrice);
    }

}
