package org.itstack.demo.design.test;

import org.itstack.demo.design.Builder;
import org.junit.Test;

/**             「各项装修物料组合套餐选配场景」
 *
* @description 一些基本物料不会变，而其组合经常变化的时候，就可以选择这样的设计模式来构建代码。
 *
 *              将一个复杂的构建与其表示相分离，使得同样的构建过程可以创建不同的表示。
 *
* @author lryepoch
* @date 2020/12/15 11:49
*
*/
public class ApiTest {

    @Test
    public void test_Builder(){
        Builder builder = new Builder();

        // 豪华欧式
        System.out.println(builder.levelOne(132.52D).getDetail());

        // 轻奢田园
        System.out.println(builder.levelTwo(98.25D).getDetail());

        // 现代简约
        System.out.println(builder.levelThree(85.43D).getDetail());
    }

}
