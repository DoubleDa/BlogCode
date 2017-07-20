package com.dyx.gscp.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * project name：GlideSourceCodeProject
 * class describe：区域抽象类
 * create person：dayongxin
 * create time：2017/7/20 下午9:03
 * alter person：dayongxin
 * alter time：2017/7/20 下午9:03
 * alter remark：
 */
public abstract class Citizen {
    protected List<Policeman> list;
    private String help = "normal";

    public String getHelp() {
        return help;
    }

    public void setHelp(String help) {
        this.help = help;
    }

    abstract void sendMessage(String help);

    public void setPoliceman() {
        list = new ArrayList<>();
    }

    public void register(Policeman policeman) {
        this.list.add(policeman);
    }

    public void unRegister(Policeman policeman) {
        this.list.remove(policeman);
    }
}
