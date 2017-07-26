package com.dyx.lldd;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * project name：LottieLoadingDialogDemo
 * class describe：
 * create person：dayongxin
 * create time：2017/7/7 下午3:43
 * alter person：dayongxin
 * alter time：2017/7/7 下午3:43
 * alter remark：
 */
public abstract class BaseActivity extends Activity {
    private LoadingDialog dialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void showLoadingDialog(Context context) {
        if (dialog == null) {
            dialog = new LoadingDialog(context, R.style.CustomDialog);
            dialog.show();
        }
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }

    public void hideLoadingDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
