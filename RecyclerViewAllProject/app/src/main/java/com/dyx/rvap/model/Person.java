package com.dyx.rvap.model;

/**
 * Author：dayongxin
 * Function：
 */
public class Person {
    private String name;
    private int age;
    private String company;
    private String school;
    private boolean isOnline;

    public Person(String name, int age, String company, String school, boolean isOnline) {
        this.name = name;
        this.age = age;
        this.company = company;
        this.school = school;
        this.isOnline = isOnline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public boolean isOnline() {
        return isOnline;
    }

    public void setOnline(boolean online) {
        isOnline = online;
    }
}
