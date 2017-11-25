package com.dyx.ahp.model;

/**
 * Author：dayongxin
 * Function：
 */
public class Person {
    private int id;
    private String name;
    private Work work;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Work getWork() {
        return work;
    }

    public void setWork(Work work) {
        this.work = work;
    }
}
