package com.dyx.ip.build;

/**
 * 奶茶饮料
 */
public class MilkTeaDrink extends Drink {
    @Override
    public String foodName() {
        return "Milk Tea Drink";
    }

    @Override
    public float foodPrice() {
        return 12.0f;
    }
}
