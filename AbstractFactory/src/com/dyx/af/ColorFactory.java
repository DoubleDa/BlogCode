package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午10:05
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        if (color == null) {
            return null;
        }
        if (color.equalsIgnoreCase(Constants.RED)) {
            return new Red();
        } else if (color.equalsIgnoreCase(Constants.GREEN)) {
            return new Green();
        } else if (color.equalsIgnoreCase(Constants.BLUE)) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String Shape) {
        return null;
    }
}
