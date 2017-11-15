package com.dyx.ip.thread;

public class ThreadTest {
    public static void main(String[] args) {
        /**
         * 1、Thread
         */
        MyThread myThread = new MyThread();
        myThread.start();
        /**
         * 2、Runnable
         */
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}
