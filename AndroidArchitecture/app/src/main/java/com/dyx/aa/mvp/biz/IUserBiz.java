package com.dyx.aa.mvp.biz;

/**
 * Author：dayongxin
 * Function：
 */
public interface IUserBiz {
    public void login(String userName, String password, OnLoginStateListener listener);
}
