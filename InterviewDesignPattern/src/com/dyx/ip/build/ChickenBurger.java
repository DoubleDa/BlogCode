package com.dyx.ip.build;

/**
 * 鸡肉汉堡
 */
public class ChickenBurger extends Burger {
    @Override
    public String foodName() {
        return "Chicken Burger";
    }

    @Override
    public float foodPrice() {
        return 28.0f;
    }
}
