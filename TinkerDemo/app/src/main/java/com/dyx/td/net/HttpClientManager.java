package com.dyx.td.net;

import com.dyx.td.net.listener.DownloadListener;
import com.dyx.td.net.listener.HttpListener;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/1 下午3:28
 * alter person：dayongxin
 * alter time：2017/7/1 下午3:28
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

    public void downloadPatch(String patchUrl, String mPatchFile, DownloadListener downloadListener) {
        
    }
}
