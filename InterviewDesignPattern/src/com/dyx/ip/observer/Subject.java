package com.dyx.ip.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建观察目标
 */
public class Subject {
    /**
     * 创建用于存储观察者的数据结构
     */
    private List<Observer> observers = new ArrayList<>();
    /**
     * 记录观察者状态
     */
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }

    /**
     * 添加到观察者列表
     *
     * @param observer
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * 通知所有观察者
     */
    private void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}
