package com.dyx.gscp.adapter;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/19 下午6:30
 * alter person：dayongxin
 * alter time：2017/7/19 下午6:30
 * alter remark：
 */
public class ObjectAdapter implements FiveV {
    private ThwV thwV;

    public ObjectAdapter(ThwV thwV) {
        this.thwV = thwV;
    }

    public int getThwV() {
        return thwV.getThwV();
    }

    @Override
    public int getFiveVoltage() {
        return 5;
    }
}
