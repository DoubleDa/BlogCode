package com.dyx.aa.mvp.presenter;

import android.os.Handler;

import com.dyx.aa.mvp.bean.UserInfo;
import com.dyx.aa.mvp.biz.IUserBiz;
import com.dyx.aa.mvp.biz.OnLoginStateListener;
import com.dyx.aa.mvp.biz.UserBiz;
import com.dyx.aa.mvp.view.IUserLoginView;

/**
 * Author：dayongxin
 * Function：
 */
public class UserLoginPresenter {
    private IUserBiz mIUserBiz;
    private IUserLoginView mIUserLoginView;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView mIUserLoginView) {
        this.mIUserBiz = new UserBiz();
        this.mIUserLoginView = mIUserLoginView;
    }

    public void login() {
        mIUserLoginView.showLoading();
        mIUserBiz.login(mIUserLoginView.getUserName(), mIUserLoginView.getPassword(), new OnLoginStateListener() {
            @Override
            public void onSuccess(final UserInfo userInfo) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        mIUserLoginView.hideLoading();
                        mIUserLoginView.toMainPage(userInfo);
                    }
                });
            }

            @Override
            public void onFailed() {
                mIUserLoginView.hideLoading();
                mIUserLoginView.showLoginError();
            }
        });
    }
}
