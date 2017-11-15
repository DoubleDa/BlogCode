package com.dyx.ip.sync;

public class SynchronizedVolatileDemo {
    /**
     * 1、不加修饰
     */
    int param1;

    public int getParam1() {
        return param1;
    }

    /**
     * 2、使用volatile
     */
    volatile int param2;

    public int getParam2() {
        return param2;
    }

    /**
     * 3、使用synchronized
     */
    int param3;

    synchronized public int getParam3() {
        return param3;
    }
}
