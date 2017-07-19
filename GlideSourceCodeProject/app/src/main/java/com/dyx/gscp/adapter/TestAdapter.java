package com.dyx.gscp.adapter;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午5:24
 * alter person：dayongxin
 * alter time：2017/7/19 下午5:24
 * alter remark：
 */
public class TestAdapter {
    public static void main(String[] args) {
        /**
         * 类适配器
         */
        ClassAdapter myAdapter = new ClassAdapter();
        System.out.println(myAdapter.getFiveVoltage());
        /**
         * 对象适配器
         */
        ObjectAdapter objectAdapter = new ObjectAdapter(new ThwV());
        System.out.println(objectAdapter.getFiveVoltage());
    }
}