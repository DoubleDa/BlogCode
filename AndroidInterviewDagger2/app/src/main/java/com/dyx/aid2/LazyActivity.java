package com.dyx.aid2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.dyx.aid2.bean.FootBaller;

import javax.inject.Inject;

import dagger.Lazy;

/**
 * Author：dayongxin
 * Function：懒加载
 */
public class LazyActivity extends AppCompatActivity {
    private static final String TAG = "***LazyActivity***";
    @Inject
    Lazy<FootBaller> footBallerLazy;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lazy);
        XApplication.get(LazyActivity.this).getActivityComponent().inject(this);
        FootBaller footBaller = footBallerLazy.get();
        footBaller.kickTheBall();
        String result = footBaller.kickTheBall();
        Log.i(TAG, result);
    }
}
