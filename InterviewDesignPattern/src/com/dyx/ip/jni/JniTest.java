package com.dyx.ip.jni;

public class JniTest {
    static {
        System.loadLibrary("hello-jni");
    }

    public static void main(String[] args) {

    }

    public native String get();

    public native String setContent(String msg);
}
