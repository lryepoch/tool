package org.itstack.demo.design.cuisine.impl;

import org.itstack.demo.design.AuthInfo;
import org.itstack.demo.design.AuthLink;
import org.itstack.demo.design.AuthService;

import java.text.ParseException;
import java.util.Date;

/**
 * 三级负责人
 * <p>
 * 审核类中会先判断是否审核通过，如果没有审核通过则返回结果给调用方，引导去审核。（这里简单模拟审核后有时间信息不为空，作为判断条件）
 * 判断完成后获取下一个审核节点；super.next();，如果不存在下一个节点，则直接返回结果。
 * 之后是根据不同的业务时间段进行判断是否需要，二级和一级的审核。
 * 最后返回下一个审核结果；next.doAuth(uId, orderId, authDate);，有点像递归调用。
 */
public class Level3AuthLink extends AuthLink {

    private Date beginDate = f.parse("2020-06-01 00:00:00");
    private Date endDate = f.parse("2020-06-25 23:59:59");

    public Level3AuthLink(String levelUserId, String levelUserName) throws ParseException {
        super(levelUserId, levelUserName);
    }

    public AuthInfo doAuth(String uId, String orderId, Date authDate) {
        Date date = AuthService.queryAuthInfo(levelUserId, orderId);
        if (null == date) {
            return new AuthInfo("0001", "单号：", orderId, " 状态：待三级审批负责人 ", levelUserName);
        }
        AuthLink next = super.next();
        if (null == next) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        if (authDate.before(beginDate) || authDate.after(endDate)) {
            return new AuthInfo("0000", "单号：", orderId, " 状态：三级审批负责人完成", " 时间：", f.format(date), " 审批人：", levelUserName);
        }

        return next.doAuth(uId, orderId, authDate);
    }

}
