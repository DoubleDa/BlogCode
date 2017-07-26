package com.dyx.td.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * project name：TinkerDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/30 下午11:12
 * alter person：dayongxin
 * alter time：2017/6/30 下午11:12
 * alter remark：
 */
@DefaultLifeCycle(application = ".MyTinkerApplication", flags = ShareConstants.TINKER_ENABLE_ALL, loadVerifyFlag = false)
public class TinkerApplicationLike extends ApplicationLike {
    /**
     * @param application
     * @param tinkerFlags
     * @param tinkerLoadVerifyFlag
     * @param applicationStartElapsedTime
     * @param applicationStartMillisTime
     * @param tinkerResultIntent
     * @function 构造方法
     */
    public TinkerApplicationLike(Application application,
                                 int tinkerFlags,
                                 boolean tinkerLoadVerifyFlag,
                                 long applicationStartElapsedTime,
                                 long applicationStartMillisTime,
                                 Intent tinkerResultIntent) {
        super(application, tinkerFlags, tinkerLoadVerifyFlag, applicationStartElapsedTime, applicationStartMillisTime, tinkerResultIntent);
    }

    /**
     * @param base
     * @function
     */
    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //支持MultiDex功能
        MultiDex.install(base);
        //初始化tinker
        TinkerManager.installTinker(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
