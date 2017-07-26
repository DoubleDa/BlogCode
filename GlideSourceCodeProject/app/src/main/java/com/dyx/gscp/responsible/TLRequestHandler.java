package com.dyx.gscp.responsible;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/26 上午11:14
 * alter person：dayongxin
 * alter time：2017/7/26 上午11:14
 * alter remark：
 */
public class TLRequestHandler implements RequestHandler {
    private RequestHandler mRequestHandler;

    public TLRequestHandler(RequestHandler mRequestHandler) {
        this.mRequestHandler = mRequestHandler;
    }

    @Override
    public void handleRequest(Request request) {
        if (request instanceof LeaveRequest) {
            System.out.println("准假！");
        } else {
            mRequestHandler.handleRequest(request);
        }
    }
}
