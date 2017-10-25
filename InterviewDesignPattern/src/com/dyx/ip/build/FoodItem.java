package com.dyx.ip.build;

/**
 * 食物条目接口
 */
public interface FoodItem {
    //食物名称
    public String foodName();

    //食物包装
    public FoodPackaging packaging();

    //食物价格
    public float foodPrice();
}
