package com.dyx.arja.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dyx.arja.R;
import com.dyx.arja.bean.TopicByIdBean;
import com.dyx.arja.constants.ApiConstants;
import com.dyx.arja.service.ApiService;
import com.orhanobut.logger.Logger;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Author：dayongxin
 * Function：
 */
public class RxRetrofitFragment extends Fragment {
    private TextView tvRxRetrofit;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx_okhttp, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        tvRxRetrofit = view.findViewById(R.id.tv_rx_okhttp);
        RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();
        Retrofit retrofit = new Retrofit
                .Builder()
                .baseUrl(ApiConstants.URL_CNODEJS_ROOT)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(rxAdapter)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);
        Observable<TopicByIdBean> call = apiService.getTopicById(ApiConstants.TOPIC_ID);
        call.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<TopicByIdBean>() {
            @Override
            public void onCompleted() {
                Logger.d("***onCompleted***");
            }

            @Override
            public void onError(Throwable e) {
                Logger.d(e.getMessage());
            }

            @Override
            public void onNext(TopicByIdBean topicByIdBean) {
                if (topicByIdBean != null) {
                    tvRxRetrofit.setText(topicByIdBean.getData().getContent());
                }
            }
        });
    }
}
