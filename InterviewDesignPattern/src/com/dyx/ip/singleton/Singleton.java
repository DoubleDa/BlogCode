package com.dyx.ip.singleton;

public enum Singleton {
    instance;

    public void showMsg() {
        System.out.println("Hello Singleton!");
    }
}
