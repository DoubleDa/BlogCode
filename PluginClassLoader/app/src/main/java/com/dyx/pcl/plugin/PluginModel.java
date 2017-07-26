package com.dyx.pcl.plugin;

import android.content.res.AssetManager;
import android.content.res.Resources;

import dalvik.system.DexClassLoader;

/**
 * project name：PluginClassLoader
 * class describe：
 * create person：dayongxin
 * create time：2017/7/5 上午10:37
 * alter person：dayongxin
 * alter time：2017/7/5 上午10:37
 * alter remark：
 */
public class PluginModel {
    public DexClassLoader mDexClassLoader;
    public AssetManager mAssetManager;
    public Resources mResources;
    /**
     * TODO 如何管理：Activity、Service、Broadcastreceiver、ContentProvider等；
     */
}
