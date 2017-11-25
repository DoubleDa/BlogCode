package com.dyx.air.local;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;

import com.dyx.air.R;

/**
 * Author：dayongxin
 * Function：使用LocalBroadcastManager
 */
public class LocalReceiverAct extends Activity {
    /**
     * 1、因广播数据在本应用范围内传播，你不用担心隐私数据泄露的问题。
     * 2、不用担心别的应用伪造广播，造成安全隐患。
     * 3、相比在系统内发送全局广播，它更高效。
     */
    private LocalBroadcastManager mLocalBroadcastManager;
    private MyLocalReceiver mMyLocalReceiver;
    private IntentFilter mIntentFilter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_receiver);
        //1、获取LocalBroadcastManager实例
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);
        mMyLocalReceiver = new MyLocalReceiver();
        mIntentFilter = new IntentFilter("mintentfilter");
        //2、注册LocalBroadcastManager
        mLocalBroadcastManager.registerReceiver(mMyLocalReceiver, mIntentFilter);
        //3、发送广播(主线程)
        Intent intent = new Intent("mintentfilter");
        Bundle bundle = new Bundle();
        bundle.putString("key", "主线程");
        intent.putExtras(bundle);
        mLocalBroadcastManager.sendBroadcast(intent);
        //3、发送广播(子线程)
        new Thread(new Runnable() {
            @Override
            public void run() {
                Intent intent1 = new Intent("mintentfilter");
                Bundle bundle1 = new Bundle();
                bundle1.putString("key", "子线程");
                intent1.putExtras(bundle1);
                mLocalBroadcastManager.sendBroadcast(intent1);
            }
        }).start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //4、注销广播
        mLocalBroadcastManager.unregisterReceiver(mMyLocalReceiver);
    }
}
