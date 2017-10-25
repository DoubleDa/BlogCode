package com.dyx.ip.build;

/**
 * 素食汉堡
 */
public class VegBurger extends Burger {
    @Override
    public String foodName() {
        return "Veg Burger";
    }

    @Override
    public float foodPrice() {
        return 22.0f;
    }
}
