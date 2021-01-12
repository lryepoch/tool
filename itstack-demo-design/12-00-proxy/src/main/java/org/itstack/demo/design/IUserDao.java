package org.itstack.demo.design;

import org.itstack.demo.design.agent.Select;

/**
 * @author lryepoch
 * @date 2021/1/12 15:58
 * @description 定义一个Dao层接口，并把自定义注解添加上。这与你使用的mybatis组件是一样的。
 */
public interface IUserDao {

    @Select("select userName from user where id = #{uId}")
    String queryUserInfo(String uId);

}
