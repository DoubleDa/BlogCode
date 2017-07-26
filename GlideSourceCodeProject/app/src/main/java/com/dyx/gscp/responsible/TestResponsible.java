package com.dyx.gscp.responsible;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/26 上午11:16
 * alter person：dayongxin
 * alter time：2017/7/26 上午11:16
 * alter remark：
 */
public class TestResponsible {
    public static void main(String[] args) {
        RequestHandler hr = new HRRequestHandler();
        RequestHandler pm = new PMRequestHandler(hr);
        RequestHandler tl = new TLRequestHandler(pm);


        //处理离职请求
        Request requestHr = new DimissionRequest();
        hr.handleRequest(requestHr);
        System.out.println("*******************");

        //处理加薪请求
        Request requestPm = new AddMoneyRequest();
        pm.handleRequest(requestPm);
        System.out.println("*******************");

        //处理请假请求
        Request requestTl = new LeaveRequest();
        tl.handleRequest(requestTl);
    }
}
