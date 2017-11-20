package com.dyx.ais.service2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/**
 * Author：dayongxin
 * Function：
 */
public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent intent1 = new Intent(context, LongTimeRunningService.class);
        context.startService(intent1);
    }
}
