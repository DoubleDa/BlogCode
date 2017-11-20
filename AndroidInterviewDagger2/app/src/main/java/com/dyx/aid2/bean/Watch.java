package com.dyx.aid2.bean;

import android.util.Log;

import javax.inject.Inject;

/**
 * Author：dayongxin
 * Function：
 */
public class Watch {
    private static final String TAG = "***Watch***";
    @Inject
    public Watch() {
    }

    public void work() {
        Log.i(TAG, "work");
    }
}
