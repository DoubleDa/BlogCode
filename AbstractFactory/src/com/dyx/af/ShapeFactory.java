package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午10:05
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String color) {
        return null;
    }

    @Override
    public Shape getShape(String Shape) {
        if (Shape == null) {
            return null;
        }
        if (Shape.equalsIgnoreCase(Constants.RECTANGLE)) {
            return new Rectangle();
        } else if (Shape.equalsIgnoreCase(Constants.SQUARE)) {
            return new Square();
        } else if (Shape.equalsIgnoreCase(Constants.CIRCLE)) {
            return new Circle();
        }
        return null;
    }
}
