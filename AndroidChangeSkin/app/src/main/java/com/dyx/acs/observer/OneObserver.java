package com.dyx.acs.observer;

import com.dyx.acs.XApplication;

/**
 * Author：dayongxin
 * Function：
 */
public class OneObserver extends Observer {
    public OneObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        XApplication.states = Integer.valueOf(subject.getState());
    }
}
