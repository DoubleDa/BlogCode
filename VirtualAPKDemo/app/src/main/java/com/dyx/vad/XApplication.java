package com.dyx.vad;

import android.app.Application;
import android.content.Context;

import com.apkfuns.logutils.LogUtils;
import com.dyx.vad.lib.virtualapk.PluginVaManager;

import java.io.File;

/**
 * project name：VirtualAPKDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/7 下午5:37
 * alter person：dayongxin
 * alter time：2017/7/7 下午5:37
 * alter remark：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initTools();
        loadPluginTask("/plugin_main.apk");
        loadPluginTask("/plugin_search.apk");
    }

    private void loadPluginTask(final String pluginName) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String apkPath = "/sdcard/virtualapk" + pluginName;
                LogUtils.i(apkPath);
                File apk = new File(apkPath);
                try {
                    PluginVaManager.getInstance().loadPlugin(getApplicationContext(), apk);
                } catch (Exception e) {
                    e.printStackTrace();
                    LogUtils.i("There is no plugin to load.");
                }
            }
        }).start();
    }

    private void initTools() {
        //初始化LogUtils
        LogUtils.configAllowLog = true;
        LogUtils.configTagPrefix = "******virtualapk-app******";
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //初始化PluginVaManager
        PluginVaManager.getInstance().init(this);
    }
}
