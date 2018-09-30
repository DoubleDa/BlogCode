package com.dyx.ncd;

import android.app.Application;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;

public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initLogger();
    }

    private void initLogger() {
        Logger.addLogAdapter(new AndroidLogAdapter());
    }
}
