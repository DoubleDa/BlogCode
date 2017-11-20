package com.dyx.aid2;

import android.app.Application;
import android.content.Context;

import com.dyx.aid2.component.ActivityComponent;
import com.dyx.aid2.component.DaggerActivityComponent;
import com.dyx.aid2.component.DaggerFootBallComponent;

/**
 * Author：dayongxin
 * Function：
 */
public class XApplication extends Application {
    ActivityComponent activityComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        activityComponent = DaggerActivityComponent.builder().build();
        DaggerFootBallComponent.builder().build();
    }

    public static XApplication get(Context context) {
        return (XApplication) context.getApplicationContext();
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
