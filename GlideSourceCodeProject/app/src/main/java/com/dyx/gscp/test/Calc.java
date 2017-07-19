package com.dyx.gscp.test;

/**
 * project name：GlideSourceCodeProject
 * class describe：上下文环境的实现
 * create person：dayongxin
 * create time：2017/7/18 下午5:36
 * alter person：dayongxin
 * alter time：2017/7/18 下午5:36
 * alter remark：
 */
public class Calc {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public double calc(double numA, double numB) {
        if (this.strategy == null) {
            throw new IllegalStateException("There is not strategy!");
        }
        return this.strategy.calc(numA, numB);
    }
}
