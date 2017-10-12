package com.dyx.otmd;

import android.app.Application;
import android.content.ComponentCallbacks2;

/**
 * Author：dayongxin
 * Function：
 */
public class XApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        switch (level) {
            /**
             * A.常用等级
             */
            case ComponentCallbacks2.TRIM_MEMORY_UI_HIDDEN:
                /**
                 * 应用程序的所有UI界面被隐藏
                 */
                break;
            /**
             * B.当应用程序是缓存的，则会收到以下几种类型的回调
             */
            case ComponentCallbacks2.TRIM_MEMORY_BACKGROUND:
                /**
                 * 手机目前内存已经很低，系统准备开始根据LRU缓存来清理进程
                 */
                break;
            case ComponentCallbacks2.TRIM_MEMORY_COMPLETE:
                /**
                 * 手机目前内存已经很低，并且我们的程序处于LRU缓存列表的最边缘位置，
                 * 系统会最优先考虑杀掉我们的应用程序，在这个时候应当尽可能地把一切
                 * 可以释放的东西都进行释放
                 */
                break;
            case ComponentCallbacks2.TRIM_MEMORY_MODERATE:
                /**
                 * 手机目前内存已经很低，并且我们的程序处于LRU缓存列表的中间位置，
                 * 如果手机内存还得不到进一步释放的话，那么我们的程序就有被系统杀掉
                 * 的风险
                 */
                break;
            /**
             * C.应用程序真正运行时的回调
             */
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_CRITICAL:
                /**
                 * 应用程序仍然正常运行，但是系统已经根据LRU缓存规则杀掉了大部分缓存
                 * 的进程了。这个时候我们应当尽可能地去释放任何不必要的资源，不然的话
                 * 系统可能会继续杀掉所有缓存中的进程，并且开始杀掉一些本来应当保持运
                 * 行的进程
                 */
                break;
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_LOW:
                /**
                 * 应用程序正常运行，并且不会被杀掉。但是目前手机的内存已经非常低了，
                 * 我们应该去释放掉一些不必要的资源以提升系统的性能，同时这也会直接
                 * 影响到我们应用程序的性能
                 */
                break;
            case ComponentCallbacks2.TRIM_MEMORY_RUNNING_MODERATE:
                /**
                 * 应用程序正常运行，并且不会被杀掉。但是目前手机的内存已经有点低了，
                 * 系统可能会开始根据LRU缓存规则来去杀死进程
                 */
                break;
            default:
                break;
        }
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
    }
}
