package com.dyx.arja;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.dyx.arja.bean.SearchResultBean;
import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Author：dayongxin
 * Function：
 */
public class RxBindingActivity extends AppCompatActivity {
    private Subscription btnSub;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rxbinding);
        initView();
    }

    private void initView() {
        /**
         * 组件Button使用RxBinding代码该这么写
         */
        Button button = (Button) findViewById(R.id.btn_rxbinding);
        btnSub = RxView.clicks(button).subscribe(new Action1<Void>() {
            @Override
            public void call(Void aVoid) {
                Logger.d("***rxbinding***");
            }
        });
        /**
         * 组件EditText使用RxBinding代码该这么写
         */
        EditText editText = (EditText) findViewById(R.id.et_rxbinding);
        Subscription etSub = RxTextView.textChanges(editText).subscribe(new Action1<CharSequence>() {
            @Override
            public void call(CharSequence charSequence) {
                Logger.d(String.valueOf("rxbinding：" + charSequence));
            }
        });
        /**
         * 组件使用RxBinding代码该这么写
         */
        EditText etSearch = (EditText) findViewById(R.id.et_search);
        Subscription searchSub = RxTextView.textChanges(etSearch)
                .filter(new Func1<CharSequence, Boolean>() {
                    @Override
                    public Boolean call(CharSequence charSequence) {
                        //字符长度大于3触发查询服务器
                        return String.valueOf(charSequence).length() > 3;
                    }
                })
                .debounce(100, TimeUnit.MILLISECONDS)//过滤100ms之内的操作
                .switchMap(new Func1<CharSequence, Observable<SearchResultBean>>() {
                    @Override
                    public Observable<SearchResultBean> call(CharSequence charSequence) {
                        //请求服务器得到响应
                        return fetchResultFromServer(String.valueOf(charSequence));
                    }
                })
                .subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<SearchResultBean>() {
                    @Override
                    public void onCompleted() {
                        Logger.d("***onCompleted***");
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(SearchResultBean searchResultBean) {
                        //TODO 处理查询结果
                    }
                });
    }

    private Observable<SearchResultBean> fetchResultFromServer(String s) {
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (null != btnSub && btnSub.isUnsubscribed()) {
            btnSub.unsubscribe();
        }
    }
}
