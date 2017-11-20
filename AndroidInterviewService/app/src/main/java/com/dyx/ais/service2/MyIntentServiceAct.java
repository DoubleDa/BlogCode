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
public class MyIntentServiceAct extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_intent_service);
        /**
         * s1
         */
        Intent intent1 = new Intent(this, MyIntentService.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("param", "s1");
        intent1.putExtras(bundle1);
        intent1.setAction("com.dyx.ais.service2.MY_INTENT_SERVICE");
        /**
         * s2
         */
        Intent intent2 = new Intent(this, MyIntentService.class);
        Bundle bundle2 = new Bundle();
        bundle2.putString("param", "s2");
        intent2.putExtras(bundle2);
        intent2.setAction("com.dyx.ais.service2.MY_INTENT_SERVICE");
        /**
         * s3
         */
        Intent intent3 = new Intent(this, MyIntentService.class);
        Bundle bundle3 = new Bundle();
        bundle3.putString("param", "s3");
        intent3.putExtras(bundle3);
        intent3.setAction("com.dyx.ais.service2.MY_INTENT_SERVICE");
        /**
         * 启动Service
         */
        startService(intent1);
        startService(intent2);
        startService(intent3);
    }
}
