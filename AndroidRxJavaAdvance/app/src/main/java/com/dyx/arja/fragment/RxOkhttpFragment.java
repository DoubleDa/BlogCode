package com.dyx.arja.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.arja.R;
import com.dyx.arja.constants.ApiConstants;
import com.orhanobut.logger.Logger;

import java.io.IOException;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Author：dayongxin
 * Function：RxJava结合OkHttp
 */
public class RxOkhttpFragment extends Fragment {
    private OkHttpClient mOkHttpClient;
    private TextView tvRxOkhttp;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx_okhttp, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tvRxOkhttp = view.findViewById(R.id.tv_rx_okhttp);
        getAsynHttp(ApiConstants.URL_CNODEJS_TOPIC_BY_ID);
    }

    private void getAsynHttp(String url) {
        getObservable(url)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<String>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull String s) {
                        Logger.d(s);
                        if (null != tvRxOkhttp && !TextUtils.isEmpty(s)) {
                            tvRxOkhttp.setText(s);
                        }
                    }

                    @Override
                    public void onError(@NonNull Throwable e) {
                        Logger.d(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        Logger.d("***onComplete***");
                    }
                });
    }

    private Observable<String> getObservable(final String url) {
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter emitter) throws Exception {
                mOkHttpClient = new OkHttpClient();
                Request request = new Request.Builder().url(url).build();
                Call call = mOkHttpClient.newCall(request);
                call.enqueue(new Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {
                        emitter.onError(new Exception(e.getMessage()));
                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String result = response.body().string();
                        emitter.onNext(result);
                        emitter.onComplete();
                    }
                });
            }
        });
        return observable;
    }
}
