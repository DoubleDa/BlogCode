package com.dyx.aid2.module;

import com.dyx.aid2.bean.FootBaller;

import dagger.Module;
import dagger.Provides;

/**
 * Author：dayongxin
 * Function：
 */
@Module
public class FootBallModule {
    @Provides
    public FootBaller providesFootBaller() {
        return new FootBaller();
    }
}
