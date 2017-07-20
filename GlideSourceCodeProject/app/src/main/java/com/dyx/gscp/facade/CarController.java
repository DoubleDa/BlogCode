package com.dyx.gscp.facade;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 上午10:41
 * alter person：dayongxin
 * alter time：2017/7/20 上午10:41
 * alter remark：
 */
public class CarController {
    //制动系统
    private PowerSystem mPowerSystem = new PowerSystem();
    //能源控制系统
    private EnergySystem mEnergySystem = new EnergySystem();
    //空调系统
    private AirConditeSystem mAirConditeSystem = new AirConditeSystem();
    //多媒体系统
    private MultiMediaSystem mMultiMediaSystem = new MultiMediaSystem();


    /**
     * 启动
     */
    public void powerOn() {
        mPowerSystem.powerOn();
    }

    /**
     * 加速
     */
    public void powerSpeed() {
        mPowerSystem.powerSpeed();
    }

    /**
     * 停止
     */
    public void powerOff() {
        mPowerSystem.powerOff();
    }

    /**
     * 补充能源
     */
    public void addEnergy() {
        mEnergySystem.addEnergy();
    }

    /**
     * 开启空调
     */
    public void airOn() {
        mAirConditeSystem.airOn();
    }

    /**
     * 制热
     */
    public void airHot() {
        mAirConditeSystem.airHot();
    }

    /**
     * 制热
     */
    public void airCold() {
        mAirConditeSystem.airCold();
    }

    /**
     * 关闭空调
     */
    public void airOff() {
        mAirConditeSystem.airOff();
    }

    /**
     * 播放音乐
     */
    public void playMusic() {
        mMultiMediaSystem.playMusic();
    }

    /**
     * 播放电影
     */
    public void playVedio() {
        mMultiMediaSystem.playVedio();
    }
}
