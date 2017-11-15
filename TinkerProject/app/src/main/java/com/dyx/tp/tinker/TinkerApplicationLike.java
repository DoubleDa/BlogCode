package com.dyx.tp.tinker;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import com.tencent.tinker.anno.DefaultLifeCycle;
import com.tencent.tinker.loader.app.ApplicationLike;
import com.tencent.tinker.loader.shareutil.ShareConstants;

/**
 * Author：dayongxin
 * Function：
 */
@DefaultLifeCycle(application = ".MyTinkerApplication", flags = ShareConstants.TINKER_ENABLE_ALL, loadVerifyFlag = false)
public class TinkerApplicationLike extends ApplicationLike {
    public TinkerApplicationLike(Application application,
                                 int tinkerFlags,
                                 boolean tinkerLoadVerifyFlag,
                                 long applicationStartElapsedTime,
                                 long applicationStartMillisTime,
                                 Intent tinkerResultIntent) {
        super(application,
                tinkerFlags,
                tinkerLoadVerifyFlag,
                applicationStartElapsedTime,
                applicationStartMillisTime,
                tinkerResultIntent);
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onBaseContextAttached(Context base) {
        super.onBaseContextAttached(base);
        //支持MultiDex功能
        MultiDex.install(base);
        //初始化tinker
        TinkerManager.installTinker(this);
    }
}
