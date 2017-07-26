package com.dyx.gscp.responsible;

/**
 * project name：GlideSourceCodeProject
 * class describe：
 * create person：dayongxin
 * create time：2017/7/26 上午11:04
 * alter person：dayongxin
 * alter time：2017/7/26 上午11:04
 * alter remark：
 */
public class HRRequestHandler implements RequestHandler {
    @Override
    public void handleRequest(Request request) {
        if (request instanceof DimissionRequest) {
            System.out.println("Hr 批准！");
        }
        System.out.println("处理完！");
    }
}
