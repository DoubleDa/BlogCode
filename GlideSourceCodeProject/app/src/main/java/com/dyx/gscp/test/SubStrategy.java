package com.dyx.gscp.test;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/18 下午5:31
 * alter person：dayongxin
 * alter time：2017/7/18 下午5:31
 * alter remark：
 */
public class SubStrategy implements Strategy {
    @Override
    public double calc(double numA, double numB) {
        return numA - numB;
    }
}
