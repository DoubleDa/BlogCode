package com.dyx.gscp.responsible;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/26 上午11:07
 * alter person：dayongxin
 * alter time：2017/7/26 上午11:07
 * alter remark：
 */
public class PMRequestHandler implements RequestHandler {
    private RequestHandler mRequestHandler;

    public PMRequestHandler(RequestHandler mRequestHandler) {
        this.mRequestHandler = mRequestHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof AddMoneyRequest) {
            System.out.println("加薪成功！");
        } else {
            mRequestHandler.handleRequest(request);
        }
    }
}
