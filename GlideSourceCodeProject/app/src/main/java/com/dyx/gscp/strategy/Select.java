package com.dyx.gscp.strategy;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/18 下午5:52
 * alter person：dayongxin
 * alter time：2017/7/18 下午5:52
 * alter remark：
 */
public class Select {
    private Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Object select() {
        return this.strategy.select();
    }
}
