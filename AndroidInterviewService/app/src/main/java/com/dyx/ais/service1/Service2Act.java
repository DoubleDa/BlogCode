package com.dyx.ais.service1;

import android.app.Activity;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.dyx.ais.R;

/**
 * Author：dayongxin
 * Function：
 */
public class Service2Act extends Activity {
    private static final String TAG = "***Service2Act***";
    private Button btnBind, btnUnBind, btnStatus;
    private boolean isBind = false;

    MyService2.MyBinder binder;
    private ServiceConnection connection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.i(TAG, "onServiceConnected");
            binder = (MyService2.MyBinder) service;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.i(TAG, "onServiceDisconnected");
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service2);
        initView();
    }

    private void initView() {
        btnBind = findViewById(R.id.btn_bind);
        btnUnBind = findViewById(R.id.btn_unbind);
        btnStatus = findViewById(R.id.btn_status);
        final Intent intent = new Intent(this, MyService2.class);
        intent.setAction("com.dyx.ais.service1.MY_SERVICE2");
        /**
         * 绑定
         */
        btnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isBind = bindService(intent, connection, Service.BIND_AUTO_CREATE);
            }
        });
        /**
         * 解绑
         */
        btnUnBind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isBind) {
                    unbindService(connection);
                    isBind = false;
                }
            }
        });
        /**
         * 获取状态
         */
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Service2Act.this, "count值为：" + binder.getCount(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
