package com.dyx.td.net.listener;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/1 下午3:32
 * alter person：dayongxin
 * alter time：2017/7/1 下午3:32
 * alter remark：
 */
public interface DownloadListener {
    void onSuccess(String successMsg);

    void onFailed(String failedMsg);

    void onProgress(int progressMsg);
}
