package org.itstack.demo.design.web;

import org.itstack.demo.design.domain.UserInfo;
import org.itstack.demo.design.door.annotation.DoDoor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**      「基于SpringBoot开发门面模式中间件，统一控制接口白名单场景」
 * 使用外观模式也可以说门面模式，结合SpringBoot中的自定义starter中间件开发的方式，统一处理所有需要白名单的地方。
 * 通过中间件的方式实现外观模式，这样的设计可以很好的增强代码的隔离性，以及复用性，不仅使用上非常灵活也降低了每一个系统都开发这样的服务带来的风险。
 *
 * 涉及的知识:
 * SpringBoot的starter中间件开发方式。
 * 面向切面编程和自定义注解的使用。
 * 外部自定义配置信息的透传，SpringBoot与Spring不同，对于此类方式获取白名单配置存在差异。
 */
@RestController
public class HelloWorldController {

    @Value("${server.port}")
    private int port;

    /**
     * @DoDoor 自定义注解
     * key：需要从入参取值的属性字段，如果是对象则从对象中取值，如果是单个值则直接使用
     * returnJson：预设拦截时返回值，是返回对象的Json
     * <p>
     * http://localhost:8080/api/queryUserInfo?userId=1001
     * http://localhost:8080/api/queryUserInfo?userId=小团团
     */
    @DoDoor(key = "userId", returnJson = "{\"code\":\"1111\",\"info\":\"非白名单可访问用户拦截！\"}")
    @RequestMapping(path = "/api/queryUserInfo", method = RequestMethod.GET)
    public UserInfo queryUserInfo(@RequestParam String userId) {
        return new UserInfo("虫虫:" + userId, 19, "天津市南开区旮旯胡同100号");
    }

}
