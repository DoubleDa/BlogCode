package com.dyx.amrdp.data.remote;

import android.app.Application;
import android.widget.Toast;

import com.dyx.amrdp.R;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;

/**
 * Author：dayongxin
 * Function：
 */
public class ExceptionSubscriber<T> extends Subscriber<T> {
    private SimpleCallback<T> simpleCallback;
    private Application application;

    public ExceptionSubscriber(SimpleCallback<T> simpleCallback, Application application) {
        this.simpleCallback = simpleCallback;
        this.application = application;
    }

    @Override
    public void onStart() {
        super.onStart();
        if (simpleCallback != null) {
            simpleCallback.onStart();
        }
    }

    @Override
    public void onCompleted() {
        if (simpleCallback != null) {
            simpleCallback.onComplete();
        }
    }

    @Override
    public void onError(Throwable e) {
        e.printStackTrace();
        if (e instanceof SocketTimeoutException) {
            Toast.makeText(application, application.getString(R.string.str_socket_timeout_exception), Toast.LENGTH_SHORT).show();
        } else if (e instanceof ConnectException) {
            Toast.makeText(application, application.getString(R.string.str_connect_exception), Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(application, "网络请求错误：" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNext(T t) {
        if (simpleCallback != null) {
            simpleCallback.onNext(t);
        }
    }
}
