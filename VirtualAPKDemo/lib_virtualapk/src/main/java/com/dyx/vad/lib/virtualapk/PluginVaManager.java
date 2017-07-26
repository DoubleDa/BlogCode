package com.dyx.vad.lib.virtualapk;

import android.content.Context;
import android.content.Intent;

import com.didi.virtualapk.PluginManager;
import com.didi.virtualapk.internal.LoadedPlugin;

import java.io.File;
import java.util.List;

/**
 * project name：VirtualAPKDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/7 下午5:41
 * alter person：dayongxin
 * alter time：2017/7/7 下午5:41
 * alter remark：
 */
public class PluginVaManager {
    private volatile static PluginVaManager mInstance = null;

    private PluginVaManager() {
    }

    public static PluginVaManager getInstance() {
        if (mInstance == null) {
            synchronized (PluginVaManager.class) {
                if (mInstance == null) {
                    mInstance = new PluginVaManager();
                }
            }
        }
        return mInstance;
    }

    /**
     * 初始化插件化框架：virtualapk
     *
     * @param context
     */
    public void init(Context context) {
        PluginManager.getInstance(context).init();
    }

    /**
     * 获取所有已加载的插件
     *
     * @param context
     * @return
     */
    public List<LoadedPlugin> getAllLoadedPlugins(Context context) {
        return PluginManager.getInstance(context).getAllLoadedPlugins();
    }

    /**
     * 通过Intent获取已加载的插件
     *
     * @param context
     * @param intent
     * @return
     */
    public LoadedPlugin getLoadedPlugin(Context context, Intent intent) {
        return PluginManager.getInstance(context).getLoadedPlugin(intent);
    }

    /**
     * 通过name获取已加载的插件
     *
     * @param context
     * @param name
     * @return
     */
    public LoadedPlugin getLoadedPlugin(Context context, String name) {
        return PluginManager.getInstance(context).getLoadedPlugin(name);
    }

    /**
     * 加载apk文件
     *
     * @param context
     * @param apkFile
     * @throws Exception
     */
    public void loadPlugin(Context context, File apkFile) throws Exception {
        PluginManager.getInstance(context).loadPlugin(apkFile);
    }
    
}
