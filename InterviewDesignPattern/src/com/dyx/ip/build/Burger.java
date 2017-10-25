package com.dyx.ip.build;

/**
 * 汉堡类
 */
public abstract class Burger implements FoodItem {


    @Override
    public FoodPackaging packaging() {
        return new PaperPack();
    }

    public abstract float foodPrice();
}
