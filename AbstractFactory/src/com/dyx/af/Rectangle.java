package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午9:24
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        LogUtils.printInfo("Draw Rectangle!");
    }
}
