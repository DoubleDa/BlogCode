package com.dyx.ad.andfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/29 下午4:24
 * alter person：dayongxin
 * alter time：2017/6/29 下午4:24
 * alter remark：
 */
public class AndfixPatchManager {
    /**
     * 声明AndfixPatchManager对象
     */
    private volatile static AndfixPatchManager mInstance = null;

    /**
     * 声明PatchManager
     */
    private PatchManager mPatchManager;

    /**
     * 私有的构造方法
     */
    private AndfixPatchManager() {
    }

    /**
     * 获取AndfixPatchManager实例
     *
     * @return
     */
    public static AndfixPatchManager getInstance() {
        if (mInstance == null) {
            synchronized (AndfixPatchManager.class) {
                if (mInstance == null) {
                    mInstance = new AndfixPatchManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * @param mContext
     * @function 初始化Andfix
     */
    public void initAndfix(Context mContext, String appVersion) {
        mPatchManager = new PatchManager(mContext);
        mPatchManager.init(appVersion);
        mPatchManager.loadPatch();
    }

    /**
     * @param path
     * @throws IOException
     * @function 添加patch
     */
    public void addAndfixPatch(String path) throws IOException {
        if (mPatchManager != null) {
            mPatchManager.addPatch(path);
        }
    }

    /**
     * @function 移除所有的andfix patch包
     */
    public void removeAllAndfixPatch() {
        if (mPatchManager != null) {
            mPatchManager.removeAllPatch();
        }
    }
}
