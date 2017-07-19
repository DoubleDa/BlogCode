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
public class FrescoStrategy implements Strategy {
    @Override
    public Object select() {
        return new FrescoUtils("Fresco");
    }
}
