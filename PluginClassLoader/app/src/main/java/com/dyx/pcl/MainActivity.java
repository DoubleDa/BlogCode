package com.dyx.pcl;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String apkPath = getExternalCacheDir().getAbsolutePath() + "/bundle.apk";
        loadApk(apkPath);
    }

    private void loadApk(String apkPath) {
        File mFile = getDir("opt", MODE_PRIVATE);
        DexClassLoader mDexClassLoader = new DexClassLoader(apkPath,
                mFile.getAbsolutePath(),
                null,
                this.getClassLoader());
        try {
            Class mClass = mDexClassLoader.loadClass("com.dyx.pcl.bundle.BundleUtils");
            if (mClass != null) {
                Object mObject = mClass.newInstance();
                Method mMethod = mClass.getMethod("getPackageResult");
                mMethod.invoke(mObject);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
