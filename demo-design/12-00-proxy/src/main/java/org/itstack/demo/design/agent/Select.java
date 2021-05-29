package org.itstack.demo.design.agent;

import java.lang.annotation.*;

/**
 * @author lryepoch
 * @date 2021/1/12 15:57
 * @description 定义了一个模拟mybatis-spring中的自定义注解，使用在方法层面
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Select {

    String value() default "";

}
