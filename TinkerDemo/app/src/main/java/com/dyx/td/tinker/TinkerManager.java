package com.dyx.td.tinker;

import android.content.Context;

import com.dyx.td.tinker.custom.CustomPatchListener;
import com.dyx.td.tinker.custom.CustomResultService;
import com.tencent.tinker.lib.patch.AbstractPatch;
import com.tencent.tinker.lib.patch.UpgradePatch;
import com.tencent.tinker.lib.reporter.DefaultLoadReporter;
import com.tencent.tinker.lib.reporter.DefaultPatchReporter;
import com.tencent.tinker.lib.reporter.LoadReporter;
import com.tencent.tinker.lib.reporter.PatchReporter;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;
import com.tencent.tinker.loader.app.ApplicationLike;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 下午10:28
 * alter person：dayongxin
 * alter time：2017/6/30 下午10:28
 * alter remark：
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
    private static CustomPatchListener mCustomPatchListener;

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
        mCustomPatchListener = new CustomPatchListener(getTinkerContext());
        /**
         * 1、安装Tinker（简单）
         */
        TinkerInstaller.install(mApplicationLike);
        /**
         * 2、安装Tinker（复杂）
         */
        //创建LoadReporter对象：patch加载阶段
        LoadReporter mLoadReporter = new DefaultLoadReporter(getTinkerContext());
        //创建PatchReporter对象：patch合成阶段
        PatchReporter mPatchReporter = new DefaultPatchReporter(getTinkerContext());
        //创建AbstractPatch对象
        AbstractPatch mAbstractPatch = new UpgradePatch();
        //安装Tinker
        TinkerInstaller.install(mApplicationLike,
                mLoadReporter,
                mPatchReporter,
                mCustomPatchListener,
                CustomResultService.class,
                mAbstractPatch);
        isInstalled = true;
    }

    public static void loadPatch(String patchPath, String md5Value) {
        if (Tinker.isTinkerInstalled()) {
            //TODO 进行patch文件校验
            mCustomPatchListener.setCurrentFileMD5(md5Value);
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
