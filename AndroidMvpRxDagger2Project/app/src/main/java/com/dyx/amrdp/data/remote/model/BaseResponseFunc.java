package com.dyx.amrdp.data.remote.model;

import com.dyx.amrdp.constants.HttpConstant;

import rx.Observable;
import rx.functions.Func1;

/**
 * Author：dayongxin
 * Function：
 */
public class BaseResponseFunc<T> implements Func1<BaseResponse<T>, Observable<T>> {
    @Override
    public Observable<T> call(BaseResponse<T> tBaseResponse) {
        if (tBaseResponse.getStatus_code() != HttpConstant.HTTP_OK) {
            return Observable.error(new Throwable(tBaseResponse.getStatus_msg()));
        } else {
            return Observable.just(tBaseResponse.getData());
        }
    }
}
