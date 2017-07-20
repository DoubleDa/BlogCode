package com.dyx.gscp.observer;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/20 下午9:17
 * alter person：dayongxin
 * alter time：2017/7/20 下午9:17
 * alter remark：
 */
public class TestObserver {
    public static void main(String[] args) {
        //浦东新区警察
        Policeman pdxqPoliceman = new PuDongNewAreaPoliceman();
        //徐汇区警察
        Policeman xhqPoliceman = new XuHuiPoliceman();

        //浦东新区区域
        Citizen citizen = new PuDongNewAreaCitizen(pdxqPoliceman);
        //
        citizen.sendMessage("unnormal");
        //
        citizen.sendMessage("normal");
        //分割线
        System.out.println("********************");
        //创建徐汇区区域
        //正常出警
        citizen = new XuHuiCitizen(xhqPoliceman);
        //发送正常消息
        citizen.sendMessage("normal");
        //发送异常消息
        citizen.sendMessage("unnormal");
    }
}
