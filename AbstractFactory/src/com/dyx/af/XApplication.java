package com.dyx.af;

/**
 * @ProjectName: AbstractFactory
 * @Description:
 * @Author:
 * @CreateDate: 18-10-8 上午10:14
 * @Version: 1.0
 * <p>Copyright: Copyright (c) 2018</p>
 */
public class XApplication {
    public static void main(String[] args) {
        /**
         *
         */
        AbstractFactory shapeFactory = FactoryProducer.getFactory(Constants.SHAPE);
        //
        Shape rectangleShape = shapeFactory.getShape(Constants.RECTANGLE);
        rectangleShape.draw();
        //
        Shape squareShape = shapeFactory.getShape(Constants.SQUARE);
        squareShape.draw();
        //
        Shape circleShape = shapeFactory.getShape(Constants.CIRCLE);
        circleShape.draw();
        /**
         *
         */
        AbstractFactory colorFactory = FactoryProducer.getFactory(Constants.COLOR);
        //
        Color redColor = colorFactory.getColor(Constants.RED);
        redColor.fill();
        //
        Color greenColor = colorFactory.getColor(Constants.GREEN);
        greenColor.fill();
        //
        Color blueColor = colorFactory.getColor(Constants.BLUE);
        blueColor.fill();
    }
}
