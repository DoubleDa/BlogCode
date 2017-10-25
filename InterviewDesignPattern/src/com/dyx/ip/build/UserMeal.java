package com.dyx.ip.build;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户就餐类
 */
public class UserMeal {
    /**
     * 存储各个食物条目
     */
    private List<FoodItem> foodItems = new ArrayList<>();

    /**
     * 添加食物条目
     *
     * @param foodItem
     */
    public void addFoodItem(FoodItem foodItem) {
        foodItems.add(foodItem);
    }

    /**
     * 获取总价
     *
     * @return
     */
    public float getAllCost() {
        float result = 0.0f;
        for (FoodItem item : foodItems) {
            result += item.foodPrice();
        }
        return result;
    }

    public void showAllItems() {
        for (FoodItem item : foodItems) {
            System.out.println("foodName：" + item.foodName());
            System.out.println("foodPrice：" + item.foodPrice());
            System.out.println("packaging：" + item.packaging().pack());
        }
    }
}
