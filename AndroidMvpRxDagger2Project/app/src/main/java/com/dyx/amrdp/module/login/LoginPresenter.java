package com.dyx.amrdp.module.login;

import com.dyx.amrdp.data.local.SPManager;
import com.dyx.amrdp.data.remote.ApiManager;
import com.dyx.amrdp.data.remote.SimpleCallback;
import com.dyx.amrdp.data.remote.model.LoginInfo;
import com.dyx.amrdp.utils.ValidatorUtil;

/**
 * Author：dayongxin
 * Function：
 */
public class LoginPresenter {
    private LoginView loginView;
    private ValidatorUtil validatorUtil;
    private ApiManager apiManager;
    private SPManager spManager;

    public LoginPresenter(LoginView loginView, ValidatorUtil validatorUtil, ApiManager apiManager, SPManager spManager) {
        this.loginView = loginView;
        this.validatorUtil = validatorUtil;
        this.apiManager = apiManager;
        this.spManager = spManager;
    }

    public void checkinfo(String username, String password) {
        loginView.isLogin(validatorUtil.validUsername(username) && validatorUtil.validPassword(password));
    }

    public void login(String username, String password) {
        apiManager.login(username, password, new SimpleCallback<LoginInfo>() {
            @Override
            public void onStart() {
                loginView.showLoading();
            }

            @Override
            public void onNext(LoginInfo loginInfo) {
                loginView.showLoginInfo(loginInfo);
            }

            @Override
            public void onComplete() {
                loginView.dismissLoading();
            }
        });
    }


    public void saveLoginInfo(String username, String password) {
        spManager.saveLoginInfo(username, password);
    }

    public String getUsername() {
        return spManager.getUserName();
    }

    public String getPassword() {
        return spManager.getPassword();
    }
}
