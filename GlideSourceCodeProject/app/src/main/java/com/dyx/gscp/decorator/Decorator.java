package com.dyx.gscp.decorator;

/**
 * project name：GlideSourceCodeProject
 * class describe：抽象装饰着
 * create person：dayongxin
 * create time：2017/7/19 下午11:32
 * alter person：dayongxin
 * alter time：2017/7/19 下午11:32
 * alter remark：
 */
public abstract class Decorator extends Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void operate() {
        component.operate();
    }
}
