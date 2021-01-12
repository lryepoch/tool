package org.itstack.demo.design;

import java.util.Date;

/**
 * @author lryepoch
 * @date 2021/1/12 11:15
 * @description 业务接口实现类
 */
public class LotteryServiceImpl extends LotteryService {

    private MinibusTargetService minibusTargetService = new MinibusTargetService();

    @Override
    protected LotteryResult doDraw(String uId) {
        // 摇号
        String lottery = minibusTargetService.lottery(uId);
        // 结果
        return new LotteryResult(uId, lottery, new Date());
    }

}
