package com.dyx.amrdp.module.login;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dyx.amrdp.R;
import com.dyx.amrdp.XApplication;
import com.dyx.amrdp.data.remote.model.LoginInfo;
import com.dyx.amrdp.module.base.BaseActivity;
import com.jakewharton.rxbinding.widget.RxTextView;

import javax.inject.Inject;

import rx.functions.Action1;

/**
 * Author：dayongxin
 * Function：
 */
public class LoginActivity extends BaseActivity implements LoginView {
    private static final String TAG = "LoginActivity";
    @Inject
    LoginPresenter loginPresenter;
    private EditText etUsername;
    private EditText etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.login(etUsername.getText().toString().trim(), etPassword.getText().toString().trim());
            }
        });
        etUsername.setText(loginPresenter.getUsername());
        etPassword.setText(loginPresenter.getPassword());

        RxTextView.textChanges(etUsername).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                loginPresenter.checkinfo(charSequence.toString(), etPassword.getText().toString().trim());
            }
        });

        RxTextView.textChanges(etPassword).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                loginPresenter.checkinfo(etUsername.getText().toString().trim(), charSequence.toString());
            }
        });
    }

    @Override
    protected void initActivityComponent() {
        XApplication.get(this).getAppComponent().plus(new LoginModule(this)).inject(this);
    }

    @Override
    public void showLoading() {
        showProgressDialog("加载中...");
    }

    @Override
    public void dismissLoading() {
        dismissProgressDialog();
    }

    @Override
    public void isLogin(boolean isLogin) {
        if (isLogin) {
            btnLogin.setEnabled(true);
            btnLogin.setBackgroundColor(Color.GREEN);
        } else {
            btnLogin.setBackgroundColor(Color.GRAY);
        }
    }

    @Override
    public void showLoginInfo(LoginInfo loginInfo) {
        loginPresenter.saveLoginInfo(loginInfo.getUsername(), loginInfo.getPassword());
        Log.i(TAG, loginInfo.toString());
    }
}
