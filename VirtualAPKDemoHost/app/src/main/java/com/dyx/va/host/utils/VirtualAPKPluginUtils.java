package com.dyx.va.host.utils;

import android.content.Context;

import com.didi.virtualapk.PluginManager;

import java.io.File;

/**
 * Author：dayongxin
 * Function：
 */
public class VirtualAPKPluginUtils {
    private Context context;
    private volatile static VirtualAPKPluginUtils instance;

    private VirtualAPKPluginUtils(Context context) {
        this.context = context;
    }

    public static VirtualAPKPluginUtils getInstance(Context context) {
        if (instance == null) {
            synchronized (VirtualAPKPluginUtils.class) {
                if (instance == null) {
                    instance = new VirtualAPKPluginUtils(context);
                }
            }
        }
        return instance;
    }

    public void loadPlugin(File file) {
        try {
            PluginManager.getInstance(context).loadPlugin(file);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
