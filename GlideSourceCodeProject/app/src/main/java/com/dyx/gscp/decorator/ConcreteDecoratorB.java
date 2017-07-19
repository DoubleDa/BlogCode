package com.dyx.gscp.decorator;

/**
 * project name：GlideSourceCodeProject
 * class describe：装饰者具体实现类
 * create person：dayongxin
 * create time：2017/7/19 下午11:37
 * alter person：dayongxin
 * alter time：2017/7/19 下午11:37
 * alter remark：
 */
public class ConcreteDecoratorB extends Decorator {
    public ConcreteDecoratorB(Component component) {
        super(component);
    }

    @Override
    public void operate() {
        super.operate();
        operateC();
        operateD();
    }

    private void operateD() {

    }

    private void operateC() {

    }
}
