package com.dyx.tp.tinker;

import android.content.Context;

import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * Author：dayongxin
 * Function：
 */
public class TinkerManager {
    /**
     * 是否安装
     */
    private static boolean isInstalled = false;
    /**
     * 声明ApplicationLike
     */
    private static ApplicationLike mApplicationLike;
    /**
     * 声明CustomPatchListener
     */
//    private static CustomPatchListener mCustomPatchListener;

    /**
     * @param mApplicationLike
     * @function 完成tinker初始化
     */
    public static void installTinker(ApplicationLike mApplicationLike) {
        mApplicationLike = mApplicationLike;
        if (isInstalled) {
            return;
        }
        //创建CustomPatchListener
//        mCustomPatchListener = new CustomPatchListener(getTinkerContext());
        /**
         * 1、安装Tinker（简单）
         */
        TinkerInstaller.install(mApplicationLike);
        /**
         * 2、安装Tinker（复杂）
         */
//        //创建LoadReporter对象：patch加载阶段
//        LoadReporter mLoadReporter = new DefaultLoadReporter(getTinkerContext());
//        //创建PatchReporter对象：patch合成阶段
//        PatchReporter mPatchReporter = new DefaultPatchReporter(getTinkerContext());
//        //创建AbstractPatch对象
//        AbstractPatch mAbstractPatch = new UpgradePatch();
//        //安装Tinker
//        TinkerInstaller.install(mApplicationLike,
//                mLoadReporter,
//                mPatchReporter,
//                mCustomPatchListener,
//                CustomResultService.class,
//                mAbstractPatch);
        isInstalled = true;
    }

    public static void loadPatch(String patchPath) {
        if (Tinker.isTinkerInstalled()) {
            TinkerInstaller.onReceiveUpgradePatch(getTinkerContext(), patchPath);
        }
    }

    /**
     * @return
     * @function 获取tinker context对象
     */
    private static Context getTinkerContext() {
        if (mApplicationLike != null) {
            return mApplicationLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
