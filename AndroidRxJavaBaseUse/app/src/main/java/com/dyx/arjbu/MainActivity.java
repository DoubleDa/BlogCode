package com.dyx.arjbu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.dyx.arjbu.bean.HeroBean;
import com.orhanobut.logger.Logger;

import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Function;
import io.reactivex.observables.GroupedObservable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRxJava();
    }

    private void initRxJava() {
        /**
         * 1、RxJava简单使用
         */
        //rxjavaBaseUse();
        /**
         * 2、RxJava使用整合在一起
         */
        //rxjavaBaseUseTogether();
        /**
         * 3、RxJava操作符：创建操作符
         */
        //rxJavaCreateOperator();
        /**
         * 4、RxJava操作符：变换操作符
         */
        //rxJavaChangeOperator();
        /**
         * 5、RxJava操作符：过滤操作符
         */
//        rxJavaFilterOperator();
        /**
         * 6、RxJava操作符：组合操作符
         */
//        rxJavaCombOperator();
        /**
         * 7、RxJava操作符：辅助操作符
         */
//        rxJavaAncillaryOperator();
        /**
         * 8、RxJava操作符：错误处理操作符
         */
//        rxjavaErrorOperator();
        /**
         * 9、RxJava操作符：条件操作符和布尔操作符
         */
//        rxjavaIfBooleanOperator();
        /**
         * 10、RxJava操作符：转换操作符
         */
//        rxjavaConversionsOperator();
        /**
         * 11、RxJava线程
         */
        Schedulers.io();
        Schedulers.newThread();
        Schedulers.computation();
        Schedulers.single();
        Schedulers.trampoline();
        Schedulers.from(new Executor() {
            @Override
            public void execute(@android.support.annotation.NonNull Runnable runnable) {

            }
        });
        AndroidSchedulers.mainThread();
    }

    private void rxjavaConversionsOperator() {
        /**
         * 1、toList
         */
//        Observable.just(1, 2, 3).toList().subscribe(new SingleObserver<List<Integer>>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onSuccess(@NonNull List<Integer> integers) {
//                for (Integer res : integers) {
//                    Logger.d(res);
//                }
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//        });
        /**
         * 2、toSortedList
         */
//        Observable.just(1, 5, 3, 4).toSortedList().subscribe(new SingleObserver<List<Integer>>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onSuccess(@NonNull List<Integer> integers) {
//                for (Integer res : integers) {
//                    Logger.d(res);
//                }
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//        });
        /**
         * 3、toMap
         */
        HeroBean h1 = new HeroBean("张飞", "C");
        HeroBean h2 = new HeroBean("赵云", "B");
        HeroBean h3 = new HeroBean("关羽", "A");
        Observable.just(h1, h2, h3).toMap(new Function<HeroBean, String>() {
            @Override
            public String apply(@NonNull HeroBean heroBean) throws Exception {
                return heroBean.getLevel();
            }
        }).subscribe(new SingleObserver<Map<String, HeroBean>>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onSuccess(@NonNull Map<String, HeroBean> stringHeroBeanMap) {
                Logger.d(stringHeroBeanMap.get("A").getName());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }
        });
    }

    private void rxjavaIfBooleanOperator() {
        /**
         * 1、all
         */
//        Observable.just(1, 2, 3, 4, 5).all(new Predicate<Integer>() {
//            @Override
//            public boolean test(@NonNull Integer integer) throws Exception {
//                return integer < 3;
//            }
//        }).subscribe(new SingleObserver<Boolean>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onSuccess(@NonNull Boolean aBoolean) {
//                Logger.d(aBoolean);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//        });
        /**
         * 2、contains和
         */
//        Observable.just(1, 2, 3, 4).contains(1).subscribe(new SingleObserver<Boolean>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onSuccess(@NonNull Boolean aBoolean) {
//                Logger.d(aBoolean);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }
//        });

//        Observable.just(1, 2, 3, 4).isEmpty().subscribe(new SingleObserver<Boolean>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onSuccess(@NonNull Boolean aBoolean) {
//                Logger.d(aBoolean);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }
//        });
        /**
         * 3、amb
         */
//        Observable obs1 = Observable.just(1, 2, 3).delay(2, TimeUnit.SECONDS);
//        Observable obs2 = Observable.just(7, 8, 9);
//        Observable.ambArray(obs1, obs2).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 4、defaultIfEmpty
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                e.onComplete();
            }
        }).defaultIfEmpty(2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Logger.d(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void rxjavaErrorOperator() {
        /**
         * 1、catch
         */
//        Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
//                for (int i = 0; i < 5; i++) {
//                    if (i > 2) {
//                        e.onError(new Throwable("This is a Throwable."));
//                    }
//                    e.onNext(i);
//                }
//                e.onComplete();
//            }
//        }).onErrorReturn(new Function<Throwable, Integer>() {
//            @Override
//            public Integer apply(@NonNull Throwable throwable) throws Exception {
//                return 7;
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 2、retry
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 5; i++) {
                    if (i > 2) {
                        e.onError(new Throwable("This is a Throwable."));
                    }
                    e.onNext(i);
                }
                e.onComplete();
            }
        }).retry(2).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Logger.d(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void rxJavaAncillaryOperator() {
        /**
         * 1、delay
         */
//        Observable.create(new ObservableOnSubscribe<Long>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<Long> e) throws Exception {
//                Long curTime = System.currentTimeMillis() / 1000;
//                e.onNext(curTime);
//            }
//        }).delay(2, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onNext(@NonNull Long aLong) {
//                Logger.d(aLong);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }

//            @Override
//            public void onComplete() {

//            }
//        });
        /**
         * 2、do
         */
//        Observable.just(1, 2, 3).doOnNext(new Consumer<Integer>() {
//            @Override
//            public void accept(Integer integer) throws Exception {
//                Logger.d("---accept---" + integer);
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d("---onNext---" + integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 3、subscribeOn和observeOn
         */
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//                e.onNext("dayongxin");
//                e.onComplete();
//            }
//        }).subscribeOn(Schedulers.newThread())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Observer<String>() {
//                    @Override
//                    public void onSubscribe(@NonNull Disposable d) {

//                    }

//                    @Override
//                    public void onNext(@NonNull String s) {
//                        Logger.d(s);
//                    }

//                    @Override
//                    public void onError(@NonNull Throwable e) {

//                    }

//                    @Override
//                    public void onComplete() {

//                    }
//                });
        /**
         * 4、timeout
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 4; i++) {
                    Thread.sleep(i * 100);
                    e.onNext(i);
                }
                e.onComplete();
            }
        }).timeout(200, TimeUnit.SECONDS, Observable.just(8, 9)).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Logger.d(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void rxJavaCombOperator() {
        /**
         * 1、startWith
         */
//        Observable.just(3, 4, 5).startWithArray(1, 2).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 2、merge
         */
//        Observable<Integer> observable1 = Observable.just(1, 2, 3);
//        Observable<Integer> observable2 = Observable.just(5, 6, 7);
//        Observable.merge(observable1, observable2).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 3、concat
         */
//        Observable<Integer> observable1 = Observable.just(1, 2, 3).subscribeOn(Schedulers.io());
//        Observable<Integer> observable2 = Observable.just(5, 6, 7);
//        Observable.concat(observable1, observable2).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//            }
//
//            @Override
//            public void onComplete() {
//            }
//        });
        /**
         * 4、zip
         */
//        Observable<String> observable1 = Observable.just("a", "b", "c");
//        Observable<Integer> observable2 = Observable.just(1, 2, 3);
//        Observable.zip(observable1, observable2, new BiFunction<String, Integer, String>() {
//            @Override
//            public String apply(@NonNull String s, @NonNull Integer integer) throws Exception {
//                return s + integer;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onNext(@NonNull String s) {
//                Logger.d(s);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }

//            @Override
//            public void onComplete() {

//            }
//        });
        /**
         * 5、combineLatest
         */
        Observable<String> observable1 = Observable.just("a", "b", "c");
        Observable<Integer> observable2 = Observable.just(1, 2, 3);
        Observable.combineLatest(observable1, observable2, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(@NonNull String s, @NonNull Integer integer) throws Exception {
                return s + integer;
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
            }

            @Override
            public void onNext(@NonNull String s) {
                Logger.d(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
            }

            @Override
            public void onComplete() {
            }
        });
    }

    private void rxJavaFilterOperator() {
        /**
         * 1、filter
         */
//        Observable.just(1, 2, 3, 4, 5).filter(new Predicate<Integer>() {
//            @Override
//            public boolean test(@NonNull Integer integer) throws Exception {
//                return integer > 3;
//            }
//        }).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }

//            @Override
//            public void onComplete() {

//            }
//        });
        /**
         * 2、elementAt
         */
//        Observable.just(1, 2, 3, 4).elementAt(2).subscribe();
        /**
         * 3、distinct
         */
//        Observable.just(1, 2, 3, 1).distinct().subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }

//            @Override
//            public void onComplete() {

//            }
//        });
        /**
         * 4、skip和take
         */
//        Observable.just(1, 2, 3, 4).skip(2).subscribe();
//        Observable.just(1, 2, 3, 4).take(2).subscribe();
        /**
         * 5、ignoreElements
         */
//        Observable.just(1, 2, 3, 4).ignoreElements().subscribe();
        /**
         * 6、throttleFirst
         */
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<Integer> e) throws Exception {
                for (int i = 0; i < 10; i++) {
                    e.onNext(i);
                    Thread.sleep(100);
                    e.onComplete();
                }
            }
        }).throttleFirst(200, TimeUnit.MILLISECONDS).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Integer integer) {
                Logger.d(integer);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void rxJavaChangeOperator() {
        /**
         * 1、map
         */
//        final String host = "http://api.dayongxin.com/";
//        Observable.just("login").map(new Function<String, String>() {
//            @Override
//            public String apply(@NonNull String s) throws Exception {
//                //拼接
//                return host + s;
//            }
//        }).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onNext(@NonNull String s) {
//                //将拼接结果发射出来
//                Logger.d(s);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }

//            @Override
//            public void onComplete() {

//            }
//        });
        /**
         * 2、flatMap和cast
         */
//        final String host = "http://api.dayongxin.com/";
//        String[] array = {"login", "register", "main"};
//        Observable.fromArray(array).flatMap(new Function<String, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(@NonNull String s) throws Exception {
//                return Observable.just(host + s);
//            }
//        }).cast(String.class).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {

//            }

//            @Override
//            public void onNext(@NonNull String s) {
//                Logger.d(s);
//            }

//            @Override
//            public void onError(@NonNull Throwable e) {

//            }

//            @Override
//            public void onComplete() {

//            }
//        });
        /**
         * 3、concatMap
         */
//        final String host = "http://api.dayongxin.com/";
//        String[] array = {"login", "register", "main"};
//        Observable.fromArray(array).concatMap(new Function<String, ObservableSource<?>>() {
//            @Override
//            public ObservableSource<?> apply(@NonNull String s) throws Exception {
//                return Observable.just(host + s);
//            }
//        }).cast(String.class).subscribe(new Observer<String>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull String s) {
//                Logger.d(s);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 4、flatMapIterable
         */
//        Integer[] array = {1, 2, 3};
//        Observable.fromArray(array).flatMapIterable(new Function<Integer, Iterable<?>>() {
//            @Override
//            public Iterable<?> apply(@NonNull Integer integer) throws Exception {
//                List<Integer> list = new ArrayList<Integer>();
//                list.add(integer + 1);
//                return list;
//            }
//        }).cast(Integer.class).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
        /**
         * 5、groupBy
         */
        HeroBean h1 = new HeroBean("张飞", "C");
        HeroBean h2 = new HeroBean("吕布", "A");
        HeroBean h3 = new HeroBean("关于", "B");
        HeroBean h4 = new HeroBean("曹操", "A");
        HeroBean h5 = new HeroBean("刘备", "B");
        HeroBean h6 = new HeroBean("诸葛亮", "A");
        HeroBean h7 = new HeroBean("孙权", "A");
        HeroBean h8 = new HeroBean("赵云", "B");
        HeroBean h9 = new HeroBean("马超", "C");
        Observable<GroupedObservable<String, HeroBean>> groupedObservableObservable = Observable
                .just(h1, h2, h3, h4, h5, h6, h7, h8, h9)
                .groupBy(new Function<HeroBean, String>() {
                    @Override
                    public String apply(@NonNull HeroBean heroBean) throws Exception {
                        return heroBean.getLevel();
                    }
                });
        Observable.concat(groupedObservableObservable).subscribe(new Observer<HeroBean>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull HeroBean heroBean) {
                Logger.d(heroBean.getName() + "--" + heroBean.getLevel());
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    private void rxJavaCreateOperator() {
        /**
         * create
         */
//        Observable.create(new ObservableOnSubscribe<String>() {
//            @Override
//            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
//
//            }
//        });
        /**
         * just
         */
//        Observable.just(new String());
        /**
         * fromArray
         */
//        String[] array = new String[]{"a", "b"};
//        Observable.fromArray(array);
        /**
         * interval
         */
        Observable.interval(3, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull Long aLong) {
                Logger.d(aLong);
            }

            @Override
            public void onError(@NonNull Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        /**
         * range
         */
//        Observable.range(0, 3).subscribe(new Observer<Integer>() {
//            @Override
//            public void onSubscribe(@NonNull Disposable d) {
//
//            }
//
//            @Override
//            public void onNext(@NonNull Integer integer) {
//                Logger.d(integer);
//            }
//
//            @Override
//            public void onError(@NonNull Throwable e) {
//
//            }
//
//            @Override
//            public void onComplete() {
//
//            }
//        });
    }

    private void rxjavaBaseUseTogether() {
        /**
         * 5、整合在一起
         */
        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter<String> e) throws Exception {
                e.onNext("dayongxin");
                e.onNext("DoubleDa");
                e.onComplete();
            }
        }).subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Logger.d(s);
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

    private void rxjavaBaseUse() {
        /**
         * 1、创建观察者
         */
        Observer<String> observer = new Observer<String>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {

            }

            @Override
            public void onNext(@NonNull String s) {
                Logger.d(s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Logger.d(e.getMessage());
            }

            @Override
            public void onComplete() {
                Logger.d("***onComplete***");
            }
        };
        /**
         * 2、创建被观察者
         */
        Observable observable = Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(@NonNull ObservableEmitter e) throws Exception {
                /**
                 * 将事件添加到任务队列
                 */
                //1、简单实现
                e.onNext("dayongxin");
                e.onNext("DoubleDa");
                e.onComplete();
            }
        });
        //还可以
//        String[] array = {"dayongxin", "DoubleDa"};
//        Observable observableFrom = Observable.fromArray(array);
        /**
         * 4、订阅
         */
        observable.subscribe(observer);
    }
}
