package com.dyx.arja.rxbus;

import com.orhanobut.logger.Logger;

import rx.Observable;
import rx.subjects.PublishSubject;
import rx.subjects.SerializedSubject;
import rx.subjects.Subject;

/**
 * Author：dayongxin
 * Function：
 */
public class RxBus {
    private Subject<Object, Object> subject = new SerializedSubject<>(PublishSubject.create());
    private volatile static RxBus instance;

    private RxBus() {

    }

    public static RxBus getInstance() {
        if (instance == null) {
            synchronized (RxBus.class) {
                if (instance == null) {
                    instance = new RxBus();
                }
            }
        }
        return instance;
    }

    /**
     * 发生事件
     *
     * @param object
     */
    public void post(Object object) {
        Logger.d(object);
        subject.onNext(object);
    }

    /**
     * 接收事件
     *
     * @param type
     * @param <T>
     * @return
     */
    public <T> Observable<T> receiver(Class<T> type) {
        return subject.ofType(type);
    }
}
