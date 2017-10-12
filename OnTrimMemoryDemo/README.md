# onTrimMemory笔记


[TOC]



## 1、能够实现onTrimMemory的组件

- Application

```
public class Application extends ContextWrapper implements ComponentCallbacks2
```
- Activity

```
public class Activity extends ContextThemeWrapper
        implements LayoutInflater.Factory2,
        Window.Callback, KeyEvent.Callback,
        OnCreateContextMenuListener, ComponentCallbacks2,
        Window.OnWindowDismissedCallback, WindowControllerCallback
```

- Fragment

注意：是**android.app.Fragment**这个Fragment而不是**android.support.v4.app.Fragment**

```
public class Fragment implements ComponentCallbacks2, OnCreateContextMenuListener
```

- Service

```
public abstract class Service extends ContextWrapper implements ComponentCallbacks2
```

- ContentProvider

```
public abstract class ContentProvider implements ComponentCallbacks2
```

## 2、OnTrimMemory回调的作用

OnTrimMemory的主要作用就是指导应用程序在不同的情况下进行自身的内存释放，以避免被系统直接杀掉，提高应用程序的用户体验。

- TRIM_MEMORY_COMPLETE

```
the process is nearing the end of the background LRU list, and if more memory isn't found soon it will be killed.
```


- TRIM_MEMORY_MODERATE

```
the process is around the middle of the background LRU list; freeing memory can help the system keep other processes running later in the list for better overall performance.
```

- TRIM_MEMORY_BACKGROUND

```
the process has gone on to the LRU list.  This is a good opportunity to clean up resources that can efficiently and quickly be re-built if the user returns to the app.
```

- TRIM_MEMORY_UI_HIDDEN

```
the process had been showing a user interface, and is no longer doing so.  Large allocations with the UI should be released at this point to allow memory to be better managed.
```

- TRIM_MEMORY_RUNNING_CRITICAL

```
the process is not an expendable background process, but the device is running extremely low on memory and is about to not be able to keep any background processes running.Your running process should free up as many non-critical resources as it can to allow that memory to be used elsewhere.  The next thing that will happen after this is called to report that nothing at all can be kept in the background, a situation that can start to notably impact the user.
```

- TRIM_MEMORY_RUNNING_LOW

```
the process is not an expendable background process, but the device is running low on memory.Your running process should free up unneeded resources to allow that memory to be used elsewhere.
```

- TRIM_MEMORY_RUNNING_MODERATE

```
the process is not an expendable background process, but the device is running moderately low on memory.Your running process may want to release some unneeded resources for use elsewhere.
```

## 3、OnTrimMemory回调中可以释放哪些资源

- 缓存

```
缓存包括一些文件缓存，图片缓存等，在用户正常使用的时候这些缓存很有作用，但当你的应用程序UI不可见的时候，这些缓存就可以被清除以减少内存的使用．比如第三方图片库的缓存。
```

- 动态生成动态添加的View

```
这些动态生成和添加的View且少数情况下才使用到的View，这时候可以被释放，下次使用的时候再进行动态生成即可。
```

## 4、OnTrimMemory与onStop之间的关系

onTrimMemory方法中的**TRIM_MEMORY_UI_HIDDEN**回调**只有当我们程序中的所有UI组件全部不可见的时候才会触发**，这和onStop方法还是有很大区别的，因为**onStop方法只是当一个Activity完全不可见的时候就会调用**，比如说用户打开了我们程序中的另一个Activity。

因此，我们可以在onStop方法中去**释放一些Activity相关的资源**，比如说取消网络连接或者注销广播接收器等，但是像UI相关的资源应该一直要等到onTrimMemory(TRIM_MEMORY_UI_HIDDEN)这个回调之后才去释放，这样可以保证如果用户只是从我们程序的一个Activity回到了另外一个Activity，界面相关的资源都不需要重新加载，从而提升响应速度。

需要注意的是，onTrimMemory的TRIM_MEMORY_UI_HIDDEN等级是在onStop方法之前调用的。

## 5、OnTrimMemory和OnLowMemory的关系？

只有实现了ComponentCallbacks2接口的类才可以回调OnTrimMemory()。下面为OnTrimMemory()说明：

```
Called when the operating system has determined that it is a good time for a process to trim unneeded memory from its process.  This will happen for example when it goes in the background and there is not enough memory to keep as many background processes running as desired.  You should never compare to exact values of the level, since new intermediate values may be added -- you will typically want to compare if the value is greater or equal to a level you are interested in.
```

只有实现了ComponentCallbacks接口的类才可以回调onLowMemory()，回调onLowMemory()的组件有：

- Application
- Activity
- ContentProvider
- Service
- Fragment(无论**android.app.Fragment**还是android.support.v4.app.Fragment)

onLowMemory()回调方法的说明：

```
This is called when the overall system is running low on memory, and
actively running processes should trim their memory usage.  While
the exact point at which this will be called is not defined,generally
it will happen when all background process have been killed.That is, before reaching the point of killing processes hosting service and foreground UI that we would like to avoid killing.
```

小贴士：ComponentCallbacks2与ComponentCallbacks的区别是什么？

- ComponentCallbacks是ComponentCallbacks2的父类；
- ComponentCallbacks是所有应用程序组件(Activity、Service、ContentProvider、Application)都通用的回调api集；
- ComponentCallbacks2是为了更细粒度的内存管理，继承自ComponentCallbacks的新回调接口。该接口在所有应用程序组件(Activity、Service、ContentProvider、Application)中都可用。

## 6、我什么要调用onTrimMemory？

尽管系统在内存不足的时候杀进程的顺序是按照LRU Cache中从低到高来的，但是它同时也会考虑杀掉那些**占用内存较高**的应用来让系统更快地获得更多的内存。

所以如果你的应用占用内存较小，就可以增加不被杀掉的几率，从而快速地恢复（如果不被杀掉，启动的时候就是热启动，否则就是冷启动，其速度差在2~3倍）。

所以说在几个不同的OnTrimMemory回调中释放自己的UI资源，可以有效地提高用户体验。

## onTrimMemory使用场景有哪些？

- 常驻内存的应用

```
一些常驻内存的应用，比如Launcher、安全中心、电话等，在用户使用过要退出的时候，需要调用OnTrimMemory来及时释放用户使用的时候所产生的多余的内存资源：比如动态生成的View、图片缓存、Fragment等
```

- 有后台Service运行的应用

```
这些应用不是常驻内存的，意味着可以被任务管理器杀掉，但是在某些场景下用户不会去杀。这类应用包括：音乐、下载等。用户退出UI界面后，音乐还在继续播放，下载程序还在运行。这时候音乐应该释放部分UI资源和Cache。
```