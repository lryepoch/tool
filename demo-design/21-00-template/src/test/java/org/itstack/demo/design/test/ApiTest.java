package org.itstack.demo.design.test;

import org.itstack.demo.design.NetMall;
import org.itstack.demo.design.impl.JDNetMall;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**     模拟爬虫各类电商商品，生成营销推广海报场景」
* 一个定义了抽象方法执行顺序的核心抽象类，以及三个模拟具体的实现(京东、淘宝、当当)的电商服务
*/
public class ApiTest {

    public Logger logger = LoggerFactory.getLogger(ApiTest.class);

    /**
     * 测试链接
     * 京东；https://item.jd.com/100008348542.html
     * 淘宝；https://detail.tmall.com/item.htm
     * 当当；http://product.dangdang.com/1509704171.html
     */
    @Test
    public void test_NetMall() {
        NetMall netMall = new JDNetMall("1000001","*******");
        String base64 = netMall.generateGoodsPoster("https://item.jd.com/100008348542.html");
        logger.info("测试结果：{}", base64);
    }

}
