package com.dyx.gscp.template;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 下午5:32
 * alter person：dayongxin
 * alter time：2017/7/20 下午5:32
 * alter remark：
 */
public class TestTemplate {
    public static void main(String[] args) {
        //数学考试模块
        AbstractExam exam = new MathExam();
        exam.finish();

        //音乐考试模块
        exam = new EnglishExam();
        exam.finish();
    }
}
