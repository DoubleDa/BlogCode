package com.dyx.aktpap;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

/**
 * Author：dayongxin
 * Function：
 */
public class KeepAliveByActivity extends Activity {
    private static final String TAG = KeepAliveByActivity.class.getName();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        //1、获取Window
        Window window = getWindow();
        //2、设置Window相关属性
        window.setGravity(Gravity.LEFT | Gravity.TOP);
        WindowManager.LayoutParams params = window.getAttributes();
        params.x = 0;
        params.y = 0;
        params.height = 1;
        params.width = 1;
        window.setAttributes(params);
    }
}
