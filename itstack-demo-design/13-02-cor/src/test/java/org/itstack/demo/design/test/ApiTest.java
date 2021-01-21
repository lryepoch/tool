package org.itstack.demo.design.test;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.AuthLink;
import org.itstack.demo.design.AuthService;
import org.itstack.demo.design.cuisine.impl.Level1AuthLink;
import org.itstack.demo.design.cuisine.impl.Level2AuthLink;
import org.itstack.demo.design.cuisine.impl.Level3AuthLink;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.util.Date;

/**
 * 「模拟618电商大促期间，项目上线流程多级负责人审批场景」
 * <p>
 * 责任链模式的核心是解决一组服务中的先后执行处理关系，就有点像你没钱花了，需要家庭财务支出审批，10块钱以下找闺女审批，100块钱先闺女审批在媳妇审批。
 * 你可以理解想象成当你要跳槽的时候被安排的明明白白的被各个领导签字放行。
 * <p>
 * 责任链模式可以让各个服务模块更加清晰，而每一个模块间可以通过next的方式进行获取。而每一个next是由继承的统一抽象类实现的。
 * 最终所有类的职责可以动态的进行编排使用，编排的过程可以做成可配置化。
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_AuthLink() throws ParseException {
        AuthLink authLink = new Level3AuthLink("1000013", "王工")
                .appendNext(new Level2AuthLink("1000012", "张经理")
                        .appendNext(new Level1AuthLink("1000011", "段总")));

        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟三级负责人审批
        AuthService.auth("1000013", "1000998004813441");
        logger.info("测试结果：{}", "模拟三级负责人审批，王工");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟二级负责人审批
        AuthService.auth("1000012", "1000998004813441");
        logger.info("测试结果：{}", "模拟二级负责人审批，张经理");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

        // 模拟一级负责人审批
        AuthService.auth("1000011", "1000998004813441");
        logger.info("测试结果：{}", "模拟一级负责人审批，段总");
        logger.info("测试结果：{}", JSON.toJSONString(authLink.doAuth("小傅哥", "1000998004813441", new Date())));

    }

}
