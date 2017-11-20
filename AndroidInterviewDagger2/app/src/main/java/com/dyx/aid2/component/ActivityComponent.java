package com.dyx.aid2.component;

import com.dyx.aid2.LazyActivity;
import com.dyx.aid2.MainActivity;
import com.dyx.aid2.SecondActivity;
import com.dyx.aid2.module.FootBallModule;
import com.dyx.aid2.module.GsonModule;
import com.dyx.aid2.scope.ApplicationScope;

import dagger.Component;

/**
 * Author：dayongxin
 * Function：
 */
@ApplicationScope
@Component(modules = GsonModule.class, dependencies = FootBallModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);

    void inject(SecondActivity secondActivity);

    void inject(LazyActivity lazyActivity);
}
