package com.dyx.pcl.plugin;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;

import dalvik.system.DexClassLoader;

/**
 * project name：PluginClassLoader
 * class describe：
 * create person：dayongxin
 * create time：2017/7/5 上午10:40
 * alter person：dayongxin
 * alter time：2017/7/5 上午10:40
 * alter remark：
 */
public class PluginManager {
    private volatile static PluginManager mInstance = null;
    private static Context mContext;
    private static File mOptFile;
    private static HashMap<String, PluginModel> mPluginMap;

    private PluginManager(Context mContext) {
        this.mContext = mContext;
        mOptFile = mContext.getDir("opt", mContext.MODE_PRIVATE);
        mPluginMap = new HashMap<>();
    }

    public static PluginManager getInstance(Context context) {
        if (mInstance == null) {
            synchronized (PluginManager.class) {
                if (mInstance == null) {
                    mInstance = new PluginManager(context);
                }
            }
        }
        return mInstance;
    }

    /**
     * 创建插件的classloader
     *
     * @param path
     */
    private static DexClassLoader createPluginDexClassLoader(String path) {
        DexClassLoader mDexClassLoader = new DexClassLoader(path, mOptFile.getAbsolutePath(), null, null);
        return mDexClassLoader;
    }

    /**
     * 为插件添加AssetManager
     *
     * @param path
     * @return
     */
    private static AssetManager createPluginAssetManager(String path) {
        try {
            AssetManager mAssetManager = AssetManager.class.newInstance();
            Method amMethod = mAssetManager.getClass().getMethod("addAssetPath", String.class);
            amMethod.invoke(mAssetManager, path);
            return mAssetManager;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 为插件创建Resources
     *
     * @param path
     * @return
     */
    private static Resources createPluginResources(String path) {
        AssetManager mAssetManager = createPluginAssetManager(path);
        Resources mResources = mContext.getResources();
        Resources pluginResources = new Resources(mAssetManager, mResources.getDisplayMetrics(), mResources.getConfiguration());
        return pluginResources;
    }

    /**
     * 加载apk文件
     *
     * @param path
     * @return
     */
    public static PluginModel loadApk(String path) {
        if (mPluginMap.get(path) != null) {
            return mPluginMap.get(path);
        }
        PluginModel mPluginModel = new PluginModel();
        mPluginModel.mDexClassLoader = createPluginDexClassLoader(path);
        mPluginModel.mAssetManager = createPluginAssetManager(path);
        mPluginModel.mResources = createPluginResources(path);
        if (mPluginMap.get(path) == null) {
            mPluginMap.put(path, mPluginModel);
        }
        return mPluginModel;
    }
}
