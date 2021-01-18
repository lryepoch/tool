package org.itstack.demo.design.cook.impl;

import org.itstack.demo.design.cook.ICook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
* 实现者具体实现(四类厨师)
*/
public class GuangDongCook implements ICook {

    private Logger logger = LoggerFactory.getLogger(ICook.class);

    public void doCooking() {
        logger.info("广东厨师，烹饪粤菜，国内民间第二大菜系，国外最有影响力的中国菜系，可以代表中国。");
    }

}
