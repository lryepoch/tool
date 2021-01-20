package org.itstack.demo.design.test;

import org.itstack.demo.design.LoginSsoDecorator;
import org.itstack.demo.design.SsoInterceptor;
import org.junit.Test;

/**        「SSO单点登录功能扩展，增加拦截用户访问方法范围场景」
 * 很多用到装饰器模式熟悉的场景
 * <p>
 * new BufferedReader(new FileReader(""));，这段代码你是否熟悉，相信学习java开发到字节流、字符流、文件流的内容时都见到了这样的代码，一层嵌套一层，一层嵌套一层，字节流转字符流等等
 * <p>
 * 装饰器主要解决的是直接继承下因功能的不断横向扩展导致子类膨胀的问题，而是用装饰器模式后就会比直接继承显得更加灵活同时这样也就不再需要考虑子类的维护。
 *
 * 在装饰器模式中有四个比较重要点抽象出来的点：
 * 抽象构件角色(Component) - 定义抽象接口
 * 具体构件角色(ConcreteComponent) - 实现抽象接口，可以是一组
 * 装饰角色(Decorator) - 定义抽象类并继承接口中的方法，保证一致性
 * 具体装饰角色(ConcreteDecorator) - 扩展装饰具体的实现逻辑
 */
public class ApiTest {

    @Test
    public void test_LoginSsoDecorator() {
        LoginSsoDecorator ssoDecorator = new LoginSsoDecorator(new SsoInterceptor());
        String request = "1successhuahua";
        boolean success = ssoDecorator.preHandle(request, "ewcdqwt40liuiu", "t");
        System.out.println("登录校验：" + request + (success ? " 放行" : " 拦截"));
    }

}
