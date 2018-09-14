package com.dyx.sid.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.dyx.sid.MainActivity;
import com.dyx.sid.constants.Constants;

public class InstallReceiver extends BroadcastReceiver {
    private static final String TAG = "InstallReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals(Constants.PACKAGE_ADDED)) {
            String name = intent.getDataString();
            Log.i(TAG, name);
        } else if (intent.getAction().equals(Constants.PACKAGE_REMOVED)) {
            String packName = intent.getDataString();
            Log.i(TAG, packName);
        } else if (intent.getAction().equals(Constants.PACKAGE_REPLACED)) {
            restartApp(context);
        }
    }

    private void restartApp(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
    }
}
