package com.dyx.arja.fragment;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.dyx.arja.R;
import com.dyx.arja.constants.ApiConstants;
import com.dyx.arja.rxbus.MyEvent;
import com.dyx.arja.rxbus.RxBus;
import com.dyx.arja.service.ApiService;
import com.hwangjr.rxbus.annotation.Subscribe;
import com.hwangjr.rxbus.annotation.Tag;
import com.orhanobut.logger.Logger;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Author：dayongxin
 * Function：RxJava替换AsyncTask
 */
public class RxRepAsyncFragment extends Fragment {
    private TextView tvRxRepAsyn;
    private ImageView ivRxJava;
    private Subscription subscription;
    private Subscription mSubscription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_rx_rep_asyn, container, false);
        com.hwangjr.rxbus.RxBus.get().register(this);
        initView(view);
        return view;
    }


    private void initView(View view) {
        tvRxRepAsyn = view.findViewById(R.id.tv_top);
        ivRxJava = view.findViewById(R.id.iv_rx);

        subscription = RxBus.getInstance().receiver(MyEvent.class).subscribe(new Action1<MyEvent>() {
            @Override
            public void call(MyEvent myEvent) {
                tvRxRepAsyn.setText(myEvent.getTitle());
            }
        });
        displayImageWithRxJava();
    }

    private void displayImageWithRxJava() {
        getImageNetworkCall()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Bitmap>() {
                    @Override
                    public void onSubscribe(@NonNull Disposable d) {

                    }

                    @Override
                    public void onNext(@NonNull Bitmap bitmap) {
                        Logger.d("aaa");
                        ivRxJava.setImageBitmap(bitmap);
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

    private Observable<Bitmap> getImageNetworkCall() {
        Observable observable = Observable.create(new ObservableOnSubscribe() {
            @Override
            public void subscribe(@NonNull final ObservableEmitter emitter) throws Exception {
                RxJavaCallAdapterFactory rxAdapter = RxJavaCallAdapterFactory.create();
                Retrofit retrofit = new Retrofit
                        .Builder()
                        .baseUrl(ApiConstants.URL_IMG_ROOT)
                        .addCallAdapterFactory(rxAdapter)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ApiService apiService = retrofit.create(ApiService.class);
                rx.Observable<ResponseBody> call = apiService.downloadImgFromNet(ApiConstants.URL_IMG);
                call.subscribeOn(rx.schedulers.Schedulers.newThread()).map(new Func1<ResponseBody, Bitmap>() {
                    @Override
                    public Bitmap call(ResponseBody responseBody) {
                        Bitmap bitmap = BitmapFactory.decodeStream(responseBody.byteStream());
                        emitter.onNext(bitmap);
                        emitter.onComplete();
                        return bitmap;
                    }
                });
            }
        });
        return observable;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
        com.hwangjr.rxbus.RxBus.get().unregister(this);
    }

    @Subscribe(tags = {@Tag(ApiConstants.RXBUS)})
    public void receiver(MyEvent event) {
        Logger.d(event.getTitle());
    }
}
