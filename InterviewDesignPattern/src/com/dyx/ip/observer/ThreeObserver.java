package com.dyx.ip.observer;

public class ThreeObserver extends Observer {

    public ThreeObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("Three Observer：" + String.valueOf(subject.getState()));
    }
}
