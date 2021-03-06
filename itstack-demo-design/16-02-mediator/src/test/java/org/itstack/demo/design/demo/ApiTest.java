package org.itstack.demo.design.demo;

import com.alibaba.fastjson.JSON;
import org.itstack.demo.design.mediator.Resources;
import org.itstack.demo.design.mediator.SqlSession;
import org.itstack.demo.design.mediator.SqlSessionFactory;
import org.itstack.demo.design.mediator.SqlSessionFactoryBuilder;
import org.itstack.demo.design.po.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Reader;
import java.util.List;

/**
 * 「按照Mybatis原理手写ORM框架，给JDBC方式操作数据库增加中介者场景」
 * <p>
 * 手写ORM框架操作数据库
 * <p>
 * 中介者模式要解决的就是复杂功能应用之间的重复调用，在这中间添加一层中介者包装服务，对外提供简单、通用、易扩展的服务能力。
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test_queryUserInfoById() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User user = session.selectOne("org.itstack.demo.design.dao.IUserDao.queryUserInfoById", 1L);
                logger.info("测试结果：{}", JSON.toJSONString(user));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void test_queryUserList() {
        String resource = "mybatis-config-datasource.xml";
        Reader reader;
        try {
            reader = Resources.getResourceAsReader(resource);
            SqlSessionFactory sqlMapper = new SqlSessionFactoryBuilder().build(reader);

            SqlSession session = sqlMapper.openSession();
            try {
                User req = new User();
                req.setAge(18);
                List<User> userList = session.selectList("org.itstack.demo.design.dao.IUserDao.queryUserList", req);
                logger.info("测试结果：{}", JSON.toJSONString(userList));
            } finally {
                session.close();
                reader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
