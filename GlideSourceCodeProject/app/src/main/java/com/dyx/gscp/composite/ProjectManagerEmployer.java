package com.dyx.gscp.composite;

import java.util.ArrayList;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 上午11:46
 * alter person：dayongxin
 * alter time：2017/7/20 上午11:46
 * alter remark：
 */
public class ProjectManagerEmployer extends Employer {
    public ProjectManagerEmployer(String name) {
        setName(name);
        employers = new ArrayList<>();
    }

    @Override
    public void add(Employer employer) {
        employers.add(employer);
    }

    @Override
    public void delete(Employer employer) {
        employers.remove(employer);
    }
}
