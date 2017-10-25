package com.dyx.ip;

import com.dyx.ip.adapter.AudioPlayer;
import com.dyx.ip.build.UserMeal;
import com.dyx.ip.build.UserMealBuilder;
import com.dyx.ip.observer.OneObserver;
import com.dyx.ip.observer.Subject;
import com.dyx.ip.observer.ThreeObserver;
import com.dyx.ip.observer.TwoObserver;
import com.dyx.ip.singleton.Singleton;
import com.dyx.ip.singleton.SingletonClass;

public class Main {

    public static void main(String[] args) {
        /**
         * 单例模式
         */
//        SingletonClass singletonClass = SingletonClass.getInstance();
//        singletonClass.showMsg();
        /**
         * 观察者模式
         */
//        Singleton.instance.showMsg();
//        //1、创建观察目标
//        Subject subject = new Subject();
//        //2、创建观察者对象
//        new OneObserver(subject);
//        new TwoObserver(subject);
//        new ThreeObserver(subject);
//        //3、更新状态为：8
//        System.out.println("---Current State is 8---");
//        subject.setState(8);
//        //4、更新状态为：99
//        System.out.println("---Current State is 99---");
//        subject.setState(99);
        /**
         * 适配器模式
         */
//        AudioPlayer audioPlayer = new AudioPlayer();
//        audioPlayer.play("mp3", "Every Breath You Take.mp3");
//        audioPlayer.play("mp4", "人在囧途.mp4");
//        audioPlayer.play("rmvb", "中国合伙人.rmvb");
//        audioPlayer.play("mkv", "匆匆那年.mkv");
//        audioPlayer.play("vlc", "Hello.vlc");
        /**
         * 建造者模式
         */
        //创建建造者
        UserMealBuilder builder = new UserMealBuilder();
        //准备素食
        UserMeal vegMeal = builder.prepareVegMeal();
        System.out.println("***veg***");
        //获取总价
        System.out.println("All Cost：" + vegMeal.getAllCost());
        //打印条目
        vegMeal.showAllItems();

        //准备非素食
        UserMeal noVegMeal = builder.prepareNoVegMeal();
        System.out.println("***no veg***");
        //获取总价
        System.out.println("All Cost：" + noVegMeal.getAllCost());
        //打印条目
        noVegMeal.showAllItems();
    }
}
