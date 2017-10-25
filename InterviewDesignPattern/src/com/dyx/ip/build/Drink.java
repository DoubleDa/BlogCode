package com.dyx.ip.build;

/**
 * 饮料类
 */
public abstract class Drink implements FoodItem {


    @Override
    public FoodPackaging packaging() {
        return new BottlePack();
    }

    @Override
    public abstract float foodPrice();
}
