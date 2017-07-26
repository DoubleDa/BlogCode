package com.dyx.ad.net.listener;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 下午1:36
 * alter person：dayongxin
 * alter time：2017/6/30 下午1:36
 * alter remark：
 */
public interface DownloadListener {
    void onSuccess(Object successMsg);

    void onFailed(Object failedMsg);

    void onProgress(int progressMsg);
}
