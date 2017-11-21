package com.dyx.amrdp.data.remote;

import android.app.Application;

import com.dyx.amrdp.data.remote.model.BaseResponseFunc;
import com.dyx.amrdp.data.remote.model.LoginInfo;

import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Author：dayongxin
 * Function：
 */
public class ApiManager {
    private ApiService apiService;
    private Application application;

    public ApiManager(ApiService apiService, Application application) {
        this.apiService = apiService;
        this.application = application;
    }

    public void login(String userName, String password, SimpleCallback<LoginInfo> simpleCallback) {
        apiService.login(userName, password)
                .flatMap(new BaseResponseFunc<LoginInfo>())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new ExceptionSubscriber<LoginInfo>(simpleCallback, application));
    }
}
