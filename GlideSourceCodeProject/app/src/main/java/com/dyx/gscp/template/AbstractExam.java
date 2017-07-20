package com.dyx.gscp.template;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 下午5:24
 * alter person：dayongxin
 * alter time：2017/7/20 下午5:24
 * alter remark：
 */
public abstract class AbstractExam {
    /**
     * 进入考场
     */
    protected void enterExamRoom() {
        System.out.println("---进入考场---");
    }

    /**
     * 签到
     */
    protected void signExamRoom() {
        System.out.println("---签到---");
    }

    /**
     * 完成答题
     */
    protected void finishExamRoom() {
        System.out.println("---完成答题---");
    }

    /**
     * 走出考场
     */
    protected void exitExamRoom() {
        System.out.println("---走出考场---");
    }

    /**
     * 签到离开
     */
    public final void finish() {
        System.out.println("***start***");
        enterExamRoom();
        signExamRoom();
        finishExamRoom();
        exitExamRoom();
        System.out.println("***end***");
    }
}
