package org.itstack.demo.design.cuisine.impl;

import org.itstack.demo.design.cook.ICook;
import org.itstack.demo.design.cuisine.ICuisine;

/**
 * 山东（鲁菜）
 */
public class ShanDongCuisine implements ICuisine {

    private ICook cook;

    public ShanDongCuisine(ICook cook) {
        this.cook = cook;
    }

    public void cook() {
        cook.doCooking();
    }

}