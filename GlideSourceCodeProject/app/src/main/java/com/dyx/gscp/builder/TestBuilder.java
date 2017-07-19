package com.dyx.gscp.builder;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午3:00
 * alter person：dayongxin
 * alter time：2017/7/19 下午3:00
 * alter remark：
 */
public class TestBuilder {
    public static void main(String[] args) {
        //创建构建器
        Builder builder = new AppleBuilder();
        //创建Director
        Director director = new Director(builder);
        //构建Director对象
        director.constructor(16, 8, "macos", 15.4, "apple", true);
        //打印构建信息
        System.out.println("Computer Info:" + builder.create().toString());
    }
}
