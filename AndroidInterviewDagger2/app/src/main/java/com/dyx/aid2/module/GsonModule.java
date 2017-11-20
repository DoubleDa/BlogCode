package com.dyx.aid2.module;

import com.dyx.aid2.scope.ApplicationScope;
import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Author：dayongxin
 * Function：
 */
@Module
public class GsonModule {
    @ApplicationScope
    @Provides
    public Gson providesGson() {
        return new Gson();
    }
}
