package org.itstack.demo.design.cuisine.impl;

import org.itstack.demo.design.cook.ICook;
import org.itstack.demo.design.cuisine.ICuisine;

/**
 * 具体命令实现(四种菜品)
 * 广东（粤菜）
 */
public class GuangDoneCuisine implements ICuisine {

    private ICook cook;

    public GuangDoneCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}
