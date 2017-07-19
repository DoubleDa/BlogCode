package com.dyx.gscp.test;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/18 下午5:33
 * alter person：dayongxin
 * alter time：2017/7/18 下午5:33
 * alter remark：
 */
public class DivStrategy implements Strategy {
    @Override
    public double calc(double numA, double numB) {
        if (numB == 0) {
            throw new IllegalArgumentException("The dividend number is not 0!");
        }
        return numA / numB;
    }
}
