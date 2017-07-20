package com.dyx.gscp.facade;

/**
 * project name：GlideSourceCodeProject
 * class describe：空调系统
 * create person：dayongxin
 * create time：2017/7/20 上午10:46
 * alter person：dayongxin
 * alter time：2017/7/20 上午10:46
 * alter remark：
 */
public class AirConditeSystem {
    /**
     * 开启空调
     */
    public void airOn() {
        System.out.println("开启空调");
    }

    /**
     * 制热
     */
    public void airHot() {
        System.out.println("制热");
    }

    /**
     * 制冷
     */
    public void airCold() {
        System.out.println("开启制冷");
    }

    /**
     * 关闭空调
     */
    public void airOff() {
        System.out.println("关闭空调");
    }
}
