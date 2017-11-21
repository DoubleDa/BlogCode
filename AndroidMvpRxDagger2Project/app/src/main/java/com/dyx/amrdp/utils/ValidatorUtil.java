package com.dyx.amrdp.utils;

import android.text.TextUtils;

/**
 * Author：dayongxin
 * Function：
 */
public class ValidatorUtil {
    public ValidatorUtil() {
    }

    public boolean validUsername(String username) {
        return !TextUtils.isEmpty(username);
    }

    public boolean validPassword(String password) {
        return !TextUtils.isEmpty(password);
    }
}
