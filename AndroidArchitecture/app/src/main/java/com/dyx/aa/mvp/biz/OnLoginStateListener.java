package com.dyx.aa.mvp.biz;

import com.dyx.aa.mvp.bean.UserInfo;

/**
 * Author：dayongxin
 * Function：
 */
public interface OnLoginStateListener {
    void onSuccess(UserInfo userInfo);

    void onFailed();
}
