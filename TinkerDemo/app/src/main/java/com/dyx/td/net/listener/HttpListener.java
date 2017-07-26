package com.dyx.td.net.listener;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/1 下午3:30
 * alter person：dayongxin
 * alter time：2017/7/1 下午3:30
 * alter remark：
 */
public interface HttpListener {
    void onSuccess(Object successMsg);

    void onFailed(Object failedMsg);
}
