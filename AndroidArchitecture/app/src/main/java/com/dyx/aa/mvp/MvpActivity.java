package com.dyx.aa.mvp;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.dyx.aa.R;
import com.dyx.aa.mvp.bean.UserInfo;
import com.dyx.aa.mvp.presenter.UserLoginPresenter;
import com.dyx.aa.mvp.view.IUserLoginView;

/**
 * Author：dayongxin
 * Function：
 */
public class MvpActivity extends Activity implements IUserLoginView {
    private EditText userNameEt, pwEt;
    private Button btnLogin;
    private UserLoginPresenter presenter = new UserLoginPresenter(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);
        initView();
    }

    private void initView() {
        userNameEt = findViewById(R.id.et_username);
        pwEt = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.login();
            }
        });
    }

    @Override
    public String getUserName() {
        return userNameEt.getText().toString().trim();
    }

    @Override
    public String getPassword() {
        return pwEt.getText().toString().trim();
    }

    @Override
    public void cleanUserName() {

    }

    @Override
    public void cleanPassword() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void toMainPage(UserInfo info) {

    }

    @Override
    public void showLoginError() {

    }
}
