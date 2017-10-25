package com.dyx.acs.observer;

/**
 * Author：dayongxin
 * Function：
 */
public abstract class Observer {
    protected Subject subject;

    public abstract void update();
}
