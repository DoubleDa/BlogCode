package com.dyx.gscp.decorator;

/**
 * project name：GlideSourceCodeProject
 * class describe：装饰者具体实现类A
 * create person：dayongxin
 * create time：2017/7/19 下午11:35
 * alter person：dayongxin
 * alter time：2017/7/19 下午11:35
 * alter remark：
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        operateA();
        operateB();
    }

    private void operateB() {
        
    }

    private void operateA() {

    }
}
