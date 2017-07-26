package com.dyx.ad.net.listener;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 上午11:55
 * alter person：dayongxin
 * alter time：2017/6/30 上午11:55
 * alter remark：
 */
public interface HttpListener {
    void onSuccess(Object successMsg);

    void onFailed(Object failedMsg);
}
