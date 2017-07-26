package com.dyx.ad.net;

import com.dyx.ad.net.listener.DownloadListener;
import com.dyx.ad.net.listener.HttpListener;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 上午11:47
 * alter person：dayongxin
 * alter time：2017/6/30 上午11:47
 * alter remark：
 */
public class HttpClientManager {

    private volatile static HttpClientManager mInstance = null;

    private HttpClientManager() {
    }

    public static HttpClientManager getInstance() {
        if (mInstance == null) {
            synchronized (HttpClientManager.class) {
                if (mInstance == null) {
                    mInstance = new HttpClientManager();
                }
            }
        }
        return mInstance;
    }

    public void checkPatchInfo(HttpListener httpListener) {

    }

    public void downloadPatchFile(String patchUrl, String mPatchFile, DownloadListener downloadListener) {

    }
}
