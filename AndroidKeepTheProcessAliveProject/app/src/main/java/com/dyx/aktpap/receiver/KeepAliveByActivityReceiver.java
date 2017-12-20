package com.dyx.aktpap.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Author：dayongxin
 * Function：
 */
public class KeepAliveByActivityReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (action.equals(Intent.ACTION_SCREEN_OFF)) {

        } else if (action.equals(Intent.ACTION_USER_PRESENT)) {

        }
    }
}
