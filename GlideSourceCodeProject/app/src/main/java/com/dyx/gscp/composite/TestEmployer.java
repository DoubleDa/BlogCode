package com.dyx.gscp.composite;

import java.util.List;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 上午11:51
 * alter person：dayongxin
 * alter time：2017/7/20 上午11:51
 * alter remark：
 */
public class TestEmployer {
    
    public static void main(String[] args) {

        //
        Employer employerPm = new ProjectManagerEmployer("PM");
        Employer employerDesigner = new DesignerEmployer("Designer");
        Employer employerUI = new UIEmployer("UI");

        //
        employerPm.add(employerDesigner);
        employerPm.add(employerUI);

        //
        List<Employer> list = employerPm.getEmployers();
        System.out.println(list.size());

        //
        for (Employer e : list) {
            System.out.println("print info:" + e.getName());
        }
    }
}
