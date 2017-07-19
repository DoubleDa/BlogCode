package com.dyx.gscp.strategy;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/18 下午5:54
 * alter person：dayongxin
 * alter time：2017/7/18 下午5:54
 * alter remark：
 */
public class TestStrategy {
    public static void main(String[] args) {
        System.out.println("选择测试：" + select(new GlideStrategy()));
        System.out.println("选择测试：" + select(new FrescoStrategy()));
    }

    public static Object select(Object strategyObject) {
        Select select = new Select();
        select.setStrategy((Strategy) strategyObject);
        return select.select();
    }
}
