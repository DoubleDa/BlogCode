package com.dyx.ip.build;

/**
 * 咖啡饮料
 */
public class CoffeeDrink extends Drink {
    @Override
    public String foodName() {
        return "Coffee Drink";
    }

    @Override
    public float foodPrice() {
        return 18.5f;
    }
}
