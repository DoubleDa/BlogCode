package com.dyx.ld;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.airbnb.lottie.LottieAnimationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * project name：LottieDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/6/26 下午1:49
 * alter person：dayongxin
 * alter time：2017/6/26 下午1:49
 * alter remark：
 */
public class ExampleActivity extends Activity {
    @BindView(R.id.lav_example)
    LottieAnimationView lavExample;
    private Unbinder mUnbinder;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        mUnbinder = ButterKnife.bind(this);
        initAnim();
    }

    private void initAnim() {
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
    }
}
