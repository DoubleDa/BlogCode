package com.dyx.ip.sync;

public class SynchronizedDemo {
    public static void main(String[] args) {
        MyObject object = new MyObject();
        ThreadA threadA = new ThreadA(object);
        ThreadB threadB = new ThreadB(object);
        threadA.start();
        threadB.start();
    }
}

class MyObject {
    synchronized public void methodA() {

    }

    synchronized public void methodB() {

    }
}

class ThreadA extends Thread {
    private MyObject object;

    public ThreadA(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodA();
    }
}

class ThreadB extends Thread {
    private MyObject object;

    public ThreadB(MyObject object) {
        this.object = object;
    }

    @Override
    public void run() {
        super.run();
        object.methodB();
    }
}