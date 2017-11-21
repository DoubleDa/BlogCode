package com.dyx.amrdp.module.login;

import com.dyx.amrdp.data.remote.model.LoginInfo;
import com.dyx.amrdp.module.base.BaseLoadView;

/**
 * Author：dayongxin
 * Function：
 */
public interface LoginView extends BaseLoadView {
    void isLogin(boolean isLogin);

    void showLoginInfo(LoginInfo loginInfo);
}
