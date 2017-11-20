package com.dyx.aid2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dyx.aid2.bean.FootBaller;

import javax.inject.Inject;

/**
 * Author：dayongxin
 * Function：
 */
public class SecondActivity extends AppCompatActivity {
    private static final String TAG = "***SecondActivity***";
    @Inject
    FootBaller footBaller;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        XApplication.get(SecondActivity.this).getActivityComponent().inject(this);
        String result = footBaller.kickTheBall();
        Log.i(TAG, result);
    }
}
