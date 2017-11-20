package com.dyx.ais.service2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.dyx.ais.R;

/**
 * Author：dayongxin
 * Function：
 */
public class NotificationServiceAct extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification_service);
        Intent intent = new Intent(this, NotificationService.class);
        intent.setAction("com.dyx.ais.service2.NOTIFICATION_SERVICE");
        startService(intent);
    }
}
