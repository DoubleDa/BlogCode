package com.dyx.gscp.test;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/18 下午5:39
 * alter person：dayongxin
 * alter time：2017/7/18 下午5:39
 * alter remark：
 */
public class TestStrategy {
    public static void main(String[] args) {
        double paramA = 18;
        double paramB = 45;
        System.out.println("加法：" + calc(new AddStrategy(), paramA, paramB));
    }

    public static double calc(Strategy strategy, double numA, double numB) {
        Calc calc = new Calc();
        calc.setStrategy(strategy);
        return calc.calc(numA, numB);
    }
}