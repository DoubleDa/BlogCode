package com.dyx.gscp.observer;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 下午9:13
 * alter person：dayongxin
 * alter time：2017/7/20 下午9:13
 * alter remark：
 */
public class PuDongNewAreaPoliceman implements Policeman {
    @Override
    public void action(Citizen citizen) {
        String help = citizen.getHelp();
        if (help.equals("normal")) {
            System.out.println("一切正常，无需出警！");
        } else {
            System.out.println("有情况，需要浦东新区警察出警！");
        }
    }
}
