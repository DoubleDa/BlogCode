package com.dyx.vad;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * project name：VirtualAPKDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/7 下午7:15
 * alter person：dayongxin
 * alter time：2017/7/7 下午7:15
 * alter remark：
 */
public abstract class BaseActivity extends Activity {
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        mUnbinder = ButterKnife.bind(this);
    }

    protected abstract int getLayoutId();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
