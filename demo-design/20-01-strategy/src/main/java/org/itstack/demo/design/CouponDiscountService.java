package org.itstack.demo.design;

/**
 * 优惠券折扣计算接口
 * <p>
 * 优惠券类型；
 * 1. 直减券
 * 2. 满减券
 * 3. 折扣券
 * 4. n元购
 *
 * 对于优惠券的设计最初可能非常简单，就是一个金额的抵扣，也没有现在这么多种类型。所以如果没有这样场景的经验话，往往设计上也是非常简单的。
 * 但随着产品功能的不断迭代，如果程序最初设计的不具备很好的扩展性，那么往后就会越来越混乱。
 *
 */
public class CouponDiscountService {

    public double discountAmount(int type, double typeContent, double skuPrice, double typeExt) {
        // 1. 直减券
        if (1 == type) {
            return skuPrice - typeContent;
        }
        // 2. 满减券
        if (2 == type) {
            if (skuPrice < typeExt) return skuPrice;
            return skuPrice - typeContent;
        }
        // 3. 折扣券
        if (3 == type) {
            return skuPrice * typeContent;
        }
        // 4. n元购
        if (4 == type) {
            return typeContent;
        }
        return 0D;
    }

}
