package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午10:02
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class Green implements Color {
    @Override
    public void fill() {
        LogUtils.printInfo("Fill Green!");
    }
}
