package com.dyx.gscp.observer;

/**
 * project name：GlideSourceCodeProject
 * class describe：具体对象：浦东新区
 * create person：dayongxin
 * create time：2017/7/20 下午9:08
 * alter person：dayongxin
 * alter time：2017/7/20 下午9:08
 * alter remark：
 */
public class PuDongNewAreaCitizen extends Citizen {
    public PuDongNewAreaCitizen(Policeman policeman) {
        setPoliceman();
        register(policeman);
    }

    @Override
    void sendMessage(String help) {
        setHelp(help);
        for (Policeman policeman : list) {
            policeman.action(this);
        }
    }
}
