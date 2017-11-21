package com.dyx.amrdp.data.local;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

/**
 * Author：dayongxin
 * Function：
 */
public class SPManager {
    public static final String SP_NAME = "my_sp";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";
    private SharedPreferences sharedPreferences;

    public SPManager(Application application) {
        sharedPreferences = application.getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
    }

    public void saveLoginInfo(String userName, String password) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(USERNAME, userName);
        editor.putString(PASSWORD, password);
        editor.commit();
    }

    public String getUserName() {
        return sharedPreferences.getString(USERNAME, "");
    }

    public String getPassword() {
        return sharedPreferences.getString(PASSWORD, "");
    }
}
