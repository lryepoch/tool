package org.itstack.demo.design;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 只有一个饭店小二的类，通过这样的一个类实现整个不同菜品的点单逻辑。
 * 提供了两个方法，一个方法用于点单添加菜品order()，另外一个方法展示菜品的信息placeOrder()
 */
public class XiaoEr {

    private Logger logger = LoggerFactory.getLogger(XiaoEr.class);

    private Map<Integer, String> cuisineMap = new ConcurrentHashMap<>();

    public void order(int cuisine) {
        // 广东（粤菜）
        if (1 == cuisine) {
            cuisineMap.put(1, "广东厨师，烹饪粤菜，宫廷最大菜系，以白切鸡为龙头。");
        }

        // 江苏（苏菜）
        if (2 == cuisine) {
            cuisineMap.put(2, "江苏厨师，烹饪苏菜，宫廷第二大菜系，古今国宴上最受人欢迎的菜系。");
        }

        // 山东（鲁菜）
        if (3 == cuisine) {
            cuisineMap.put(3, "山东厨师，烹饪鲁菜，宫廷最大菜系之一，以孔府风味为龙头。");
        }

        // 四川（川菜）
        if (4 == cuisine) {
            cuisineMap.put(4, "四川厨师，烹饪川菜，中国最有特色的菜系，也是民间最大菜系。");
        }

    }

    public void placeOrder() {
        logger.info("菜单：{}", JSON.toJSONString(cuisineMap));
    }

}
