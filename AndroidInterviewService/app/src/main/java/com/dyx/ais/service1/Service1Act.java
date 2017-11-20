package com.dyx.ais.service1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;

import com.dyx.ais.R;

/**
 * Author：dayongxin
 * Function：
 */
public class Service1Act extends Activity {
    private Button btnStart, btnStop;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service1);
        initView();
    }

    private void initView() {
        btnStart = findViewById(R.id.btn_start);
        btnStop = findViewById(R.id.btn_stop);
        final Intent intent = new Intent(this, MyService1.class);
        intent.setAction("com.dyx.ais.service1.MY_SERVICE1");
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //开启Service
                startService(intent);
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //停止Service
                stopService(intent);
            }
        });
    }
}
