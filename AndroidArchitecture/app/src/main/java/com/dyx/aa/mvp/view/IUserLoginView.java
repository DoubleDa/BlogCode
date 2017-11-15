package com.dyx.aa.mvp.view;

import com.dyx.aa.mvp.bean.UserInfo;

/**
 * Author：dayongxin
 * Function：
 */
public interface IUserLoginView {
    String getUserName();

    String getPassword();

    void cleanUserName();

    void cleanPassword();

    void showLoading();

    void hideLoading();

    void toMainPage(UserInfo info);

    void showLoginError();
}
