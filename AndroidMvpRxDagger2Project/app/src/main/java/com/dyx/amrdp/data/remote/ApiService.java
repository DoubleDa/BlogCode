package com.dyx.amrdp.data.remote;

import com.dyx.amrdp.data.remote.model.BaseResponse;
import com.dyx.amrdp.data.remote.model.LoginInfo;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Author：dayongxin
 * Function：
 */
public interface ApiService {
    String HOST_URL = "http://192.168.31.223:3003/";

    @GET("login")
    Observable<BaseResponse<LoginInfo>> login(@Query("username") String username, @Query("password") String password);
}
