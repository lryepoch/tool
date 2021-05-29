package org.itstack.demo.design.test;

import org.itstack.demo.design.Context;
import org.itstack.demo.design.impl.MJCouponDiscount;
import org.itstack.demo.design.impl.NYGCouponDiscount;
import org.itstack.demo.design.impl.ZJCouponDiscount;
import org.itstack.demo.design.impl.ZKCouponDiscount;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**         「模拟多种营销类型优惠券，折扣金额计算策略场景」
 * @author lryepoch
 * @date 2021/1/12 15:05
 * @description 通过策略设计模式的使用可以把我们方法中的if语句优化掉，大量的if语句使用会让代码难以扩展，也不好维护，同时在后期遇到各种问题也很难维护。
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_zj() {
        // 直减；100-10，商品100元
        Context<Double> context = new Context<>(new ZJCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(10D, new BigDecimal(100));
        logger.info("测试结果：直减优惠后金额 {}", discountAmount);
    }

    @Test
    public void test_mj() {
        // 满100减10，商品100元
        Context<Map<String,String>> context = new Context<Map<String,String>>(new MJCouponDiscount());
        Map<String,String> mapReq = new HashMap<String, String>();
        mapReq.put("x","100");
        mapReq.put("n","10");
        BigDecimal discountAmount = context.discountAmount(mapReq, new BigDecimal(100));
        logger.info("测试结果：满减优惠后金额 {}", discountAmount);
    }


    @Test
    public void test_zk() {
        // 折扣9折，商品100元
        Context<Double> context = new Context<Double>(new ZKCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(0.9D, new BigDecimal(100));
        logger.info("测试结果：折扣9折后金额 {}", discountAmount);
    }

    @Test
    public void test_nyg() {
        // n元购；100-10，商品100元
        Context<Double> context = new Context<Double>(new NYGCouponDiscount());
        BigDecimal discountAmount = context.discountAmount(90D, new BigDecimal(100));
        logger.info("测试结果：n元购优惠后金额 {}", discountAmount);
    }

}
