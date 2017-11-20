package com.dyx.ais.service2;

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
public class LongTimeRunningAct extends Activity {
    private Button btnSend;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_long_time_running);
        btnSend = findViewById(R.id.btn_send_broadcast);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendBroadcast(new Intent(LongTimeRunningAct.this, AlarmReceiver.class));
            }
        });
    }
}
