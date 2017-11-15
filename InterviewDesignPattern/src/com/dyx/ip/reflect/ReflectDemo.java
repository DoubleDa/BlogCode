package com.dyx.ip.reflect;

import java.lang.reflect.Constructor;

public class ReflectDemo {
    public static void main(String[] args) {
        /**
         * 方式一：获取包名和类名称
         */
//        User user = new User();
//        Class<? extends User> userClass1 = user.getClass();
//        printInfo("包名：" + userClass1.getPackage().getName() + "类名：" + userClass1.getName());
        /**
         * 方式二：验证所有的类都是Class类的实例对象
         */
        User user1 = null;
        User user2 = null;
        try {
            Class<?> userClass2 = Class.forName("com.dyx.ip.reflect.User");
//            printInfo("包名：" + userClass2.getPackage().getName() + "类名：" + userClass2.getName());
            //通过Java反射机制，用Class创建类对象[反射存在的意义]
//            User user = (User) userClass2.newInstance();
//            user.setAge(18);
//            user.setName("dyx");
//            printInfo("\n" + user.getName());
            //通过Java反射机制得到一个类的构造函数，并实现创建带参实例对象
            Constructor<?>[] constructors = userClass2.getConstructors();
            user1 = (User) constructors[0].newInstance();
            user1.setName("ddd");
            user2 = (User) constructors[1].newInstance("ddd", 18);
            printInfo("User1：" + user1.getAge() + user1.getName() + "\n" + "User2" + user2.getAge() + user2.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        /**
         * 方式三：
         */
//        Class<? extends User> userClass3 = User.class;
//        printInfo("包名：" + userClass3.getPackage().getName() + "类名：" + userClass3.getName());

    }

    private static void printInfo(String msg) {
        System.out.print(msg);
    }

}
