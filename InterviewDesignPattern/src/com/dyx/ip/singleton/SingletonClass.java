package com.dyx.ip.singleton;

public class SingletonClass {
    /**
     * 1、懒汉式，线程不安全
     */
//    private static SingletonClass instance;
//
//    private SingletonClass() {
//
//    }
//
//    public static SingletonClass getInstance() {
//        if (instance == null) {
//            instance = new SingletonClass();
//        }
//        return instance;
//    }

    /**
     * 2、懒汉式，线程安全
     */
//    private static SingletonClass instance;
//
//    private SingletonClass() {
//
//    }
//
//    public static synchronized SingletonClass getInstance() {
//        if (instance == null) {
//            instance = new SingletonClass();
//        }
//        return instance;
//    }

    /**
     * 3、饿汉式
     */
//    private static SingletonClass instance = new SingletonClass();
//
//    private SingletonClass() {
//
//    }
//
//    public static SingletonClass getInstance() {
//        return instance;
//    }

    /**
     * 4、双检锁/双重校验锁
     */
//    private volatile static SingletonClass instance;
//
//    private SingletonClass() {
//
//    }
//
//    public static SingletonClass getInstance() {
//        if (instance == null) {
//            synchronized (SingletonClass.class) {
//                if (instance == null) {
//                    instance = new SingletonClass();
//                }
//            }
//        }
//        return instance;
//    }

    /**
     * 5、静态内部类
     */

//    private static class SingletonClassHolder {
//        private static final SingletonClass INSTANCE = new SingletonClass();
//    }
//
//    private SingletonClass() {
//
//    }
//
//    public static final SingletonClass getInstance() {
//        return SingletonClassHolder.INSTANCE;
//    }

    /**
     * 6、枚举
     */

    public void showMsg() {
        System.out.println("Hello Singleton!");
    }
}
