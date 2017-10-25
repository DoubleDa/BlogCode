package com.dyx.ip.observer;

public class OneObserver extends Observer {

    /**
     * 构造方法
     *
     * @param subject
     */
    public OneObserver(Subject subject) {
        this.subject = subject;
        //将观察目标绑定到观察者
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("One Observer：" + String.valueOf(subject.getState()));
    }
}
