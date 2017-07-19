package com.dyx.gscp.decorator;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午11:38
 * alter person：dayongxin
 * alter time：2017/7/19 下午11:38
 * alter remark：
 */
public class TestDecorator {
    public static void main(String[] args) {
        //构建被装饰的组件对象
        Component component = new ConcreteComponent();
        //根据组件对象构建装饰者对象A
        Decorator decoratorA = new ConcreteDecoratorA(component);
        decoratorA.operate();

        Decorator decoratorB = new ConcreteDecoratorB(component);
        decoratorB.operate();
    }
}
