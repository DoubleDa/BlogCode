package com.dyx.ad;

import android.app.Application;

import com.dyx.ad.andfix.AndfixPatchManager;
import com.dyx.ad.utils.Utils;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/29 下午2:00
 * alter person：dayongxin
 * alter time：2017/6/29 下午2:00
 * alter remark：
 */
public class XApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        //初始化Andfix
        initAndfix();
        //初始化Logger
        initLogger();
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }

    private void initAndfix() {
        AndfixPatchManager.getInstance().initAndfix(this, Utils.getAppVersion(this));
    }
}
