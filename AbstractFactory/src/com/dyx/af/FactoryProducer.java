package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午10:14
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String type) {
        if (type.equalsIgnoreCase(Constants.SHAPE)) {
            return new ShapeFactory();
        } else if (type.equalsIgnoreCase(Constants.COLOR)) {
            return new ColorFactory();
        }
        return null;
    }
}
