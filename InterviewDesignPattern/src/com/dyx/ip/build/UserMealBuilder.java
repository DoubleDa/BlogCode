package com.dyx.ip.build;

/**
 * 用户就餐构建者
 */
public class UserMealBuilder {
    /**
     * 准备素食餐
     *
     * @return
     */
    public UserMeal prepareVegMeal() {
        UserMeal userMeal = new UserMeal();
        userMeal.addFoodItem(new VegBurger());
        userMeal.addFoodItem(new MilkTeaDrink());
        return userMeal;
    }

    /**
     * 准备非素食
     *
     * @return
     */
    public UserMeal prepareNoVegMeal() {
        UserMeal userMeal = new UserMeal();
        userMeal.addFoodItem(new ChickenBurger());
        userMeal.addFoodItem(new CoffeeDrink());
        userMeal.addFoodItem(new CokeDrink());
        userMeal.addFoodItem(new MilkTeaDrink());
        return userMeal;
    }
}
