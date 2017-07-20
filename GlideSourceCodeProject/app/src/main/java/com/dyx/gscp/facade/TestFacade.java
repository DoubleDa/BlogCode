package com.dyx.gscp.facade;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 上午11:00
 * alter person：dayongxin
 * alter time：2017/7/20 上午11:00
 * alter remark：
 */
public class TestFacade {
    public static void main(String[] args) {
        CarController carController = new CarController();
        //启动
        carController.powerOn();
        //加速
        carController.powerSpeed();
        //停止
        carController.powerOff();
        //开启空调
        carController.airOn();
        //关闭空调
        carController.airOff();
        //空调制热
        carController.airHot();
        //空调制冷
        carController.airCold();
        //添加能源
        carController.addEnergy();
        //播放音乐
        carController.playMusic();
        //播放电影
        carController.playVedio();
    }
}
