package com.dyx.ip.sync;

public class SynchronizedTest {
    synchronized public void methodA() {
        //...
    }

    public void methodB() {
        synchronized (this) {
            //...
        }
    }
}
