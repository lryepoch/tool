package org.itstack.demo.design.test;

import org.itstack.demo.design.DataView;
import org.itstack.demo.design.visitor.impl.Parent;
import org.itstack.demo.design.visitor.impl.Principal;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**         「模拟家长与校长，对学生和老师的不同视角信息的访问场景」
 * 想让不同视角的用户获取关心的信息，就比较适合使用观察者模式来实现，从而让实体与业务解耦，增强扩展性。但观察者模式的整体类结构相对复杂，需要梳理清楚再开发。
 * <p>
 * 有以下几点：
 * 建立用户抽象类和抽象访问方法，再由不同的用户实现；老师和学生。
 * 建立访问者接口，用于不同人员的访问操作；校长和家长。
 * 最终是对数据的看板建设，用于实现不同视角的访问结果输出。
 * <p></>
 * 家长视角看到学生的排名；排名：62、排名：51、排名：16、排名：98。
 * 校长视角看到班级升学率；升学率：70.62、升学率：23.15、升学率：70.98、升学率：90.14。
 */
public class ApiTest {

    private Logger logger = LoggerFactory.getLogger(ApiTest.class);

    @Test
    public void test() {
        DataView dataView = new DataView();

        logger.info("\r\n家长视角访问：");
        dataView.show(new Parent());     // 家长

        logger.info("\r\n校长视角访问：");
        dataView.show(new Principal());  // 校长
    }

}
