package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午10:00
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        LogUtils.printInfo("Draw Circle!");
    }
}
