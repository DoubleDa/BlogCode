package com.dyx.air.local;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;

/**
 * Author：dayongxin
 * Function：
 */
public class MyLocalReceiver extends BroadcastReceiver {
    private static final String TAG = "***MyLocalReceiver***";

    @Override
    public void onReceive(Context context, Intent intent) {
        String result = intent.getAction();
        if (!TextUtils.isEmpty(result) && result.equals("mintentfilter")) {
            Log.i(TAG, intent.getStringExtra("key") + Thread.currentThread().getName());
        }
    }
}
