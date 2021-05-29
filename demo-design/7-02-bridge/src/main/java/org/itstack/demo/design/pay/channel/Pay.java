package org.itstack.demo.design.pay.channel;

import org.itstack.demo.design.pay.mode.IPayMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;

/**
 * 支付类型桥接抽象类
 * 在这个类中定义了支付方式的需要实现的划账接口：transfer，以及桥接接口；IPayMode，并在构造函数中用户方自行选择支付方式。
 * 如果没有接触过此类实现，可以重点关注 IPayMode payMode，这部分是桥接的核心。
 */
public abstract class Pay {

    protected Logger logger = LoggerFactory.getLogger(Pay.class);

    protected IPayMode payMode;

    public Pay(IPayMode payMode) {
        this.payMode = payMode;
    }

    public abstract String transfer(String uId, String tradeId, BigDecimal amount);

}
