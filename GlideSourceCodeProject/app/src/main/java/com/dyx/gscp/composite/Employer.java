package com.dyx.gscp.composite;

import java.util.List;

/**
 * project name：GlideSourceCodeProject
 * class describe：雇员抽象类
 * create person：dayongxin
 * create time：2017/7/20 上午11:41
 * alter person：dayongxin
 * alter time：2017/7/20 上午11:41
 * alter remark：
 */
public abstract class Employer {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void add(Employer employer);

    public abstract void delete(Employer employer);

    /**
     * 下属
     */
    public List<Employer> employers;

    public void printInfo() {
        System.out.println(name);
    }

    public List<Employer> getEmployers() {
        return this.employers;
    }
}
