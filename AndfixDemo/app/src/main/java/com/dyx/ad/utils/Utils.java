package com.dyx.ad.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * project name：AndfixDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/29 下午2:07
 * alter person：dayongxin
 * alter time：2017/6/29 下午2:07
 * alter remark：
 */
public class Utils {
    public static String getAppVersion(Context mContext) {
        PackageManager mPackageManager = mContext.getPackageManager();
        try {
            PackageInfo info = mPackageManager.getPackageInfo(mContext.getPackageName(), 0);
            return info != null ? info.versionName : "";
        } catch (PackageManager.NameNotFoundException e) {
            return "";
        }
    }
}
