package com.dyx.lldd;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.StyleRes;

/**
 * project name：LottieLoadingDialogDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/7 下午3:48
 * alter person：dayongxin
 * alter time：2017/7/7 下午3:48
 * alter remark：
 */
public class LoadingDialog extends Dialog {
    public LoadingDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);
    }
}
