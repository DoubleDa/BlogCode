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
public class EnglishExam extends AbstractExam {
    @Override
    protected void signExamRoom() {
        super.signExamRoom();
        System.out.println("---需要领取听力耳机---");
    }
}
