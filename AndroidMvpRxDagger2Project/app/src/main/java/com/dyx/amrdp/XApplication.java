package com.dyx.amrdp;

import android.app.Application;
import android.content.Context;

import com.dyx.amrdp.di.AppComponent;
import com.dyx.amrdp.di.AppModule;
import com.dyx.amrdp.di.DaggerAppComponent;

/**
 * Author：dayongxin
 * Function：
 */
public class XApplication extends Application {
    private AppComponent appComponent;

    public static XApplication get(Context context) {
        return (XApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
