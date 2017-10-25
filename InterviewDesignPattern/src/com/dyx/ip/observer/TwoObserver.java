package com.dyx.ip.observer;

public class TwoObserver extends Observer {
    /**
     * 构造方法
     *
     * @param subject
     */
    public TwoObserver(Subject subject) {
        this.subject = subject;
        //将观察目标绑定到观察者
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Two Observer：" + String.valueOf(subject.getState()));
    }
}
