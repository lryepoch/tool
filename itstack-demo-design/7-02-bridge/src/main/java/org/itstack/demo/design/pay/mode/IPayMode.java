package org.itstack.demo.design.pay.mode;

/**
* 任何一个支付模式；刷脸、指纹、密码，都会过不同程度的安全风控，这里定义一个安全校验接口
*/
public interface IPayMode {

    boolean security(String uId);

}
