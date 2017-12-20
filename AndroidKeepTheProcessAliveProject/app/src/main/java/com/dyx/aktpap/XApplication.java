package com.dyx.aktpap;

import android.app.Application;
import android.os.StrictMode;

import com.squareup.leakcanary.LeakCanary;

/**
 * Author：dayongxin
 * Function：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setupLeakCanary();

    }

    private void setupLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        enabledStrictMode();
        LeakCanary.install(this);
    }

    private void enabledStrictMode() {
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder() //
                .detectAll() //
                .penaltyLog() //
                .penaltyDeath() //
                .build());
    }
}
