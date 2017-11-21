package com.dyx.amrdp.data.remote;

/**
 * Author：dayongxin
 * Function：
 */
public interface SimpleCallback<T> {
    void onStart();

    void onNext(T t);

    void onComplete();
}
