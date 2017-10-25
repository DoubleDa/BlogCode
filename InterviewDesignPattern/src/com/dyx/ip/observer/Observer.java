package com.dyx.ip.observer;

public abstract class Observer {
    /**
     * 观察目标
     */
    protected Subject subject;

    /**
     * 通知更新方法
     */
    public abstract void update();
}
