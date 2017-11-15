package com.dyx.aa.mvp.biz;

import com.dyx.aa.mvp.bean.UserInfo;

/**
 * Author：dayongxin
 * Function：
 */
public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String password, final OnLoginStateListener listener) {
        new Thread() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (userName.equals("dayongxin") && password.equals("qwertyuiop")) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setUserName(userName);
                    userInfo.setPassword(password);
                    listener.onSuccess(userInfo);
                } else {
                    listener.onFailed();
                }
            }
        }.start();
    }
}
