package com.dyx.aid2.module;

import com.dyx.aid2.anno.Diesel;
import com.dyx.aid2.anno.Gasoline;
import com.dyx.aid2.bean.DieselEngine;
import com.dyx.aid2.bean.Engine;
import com.dyx.aid2.bean.GasolineEngine;

import dagger.Module;
import dagger.Provides;

/**
 * Author：dayongxin
 * Function：
 */
@Module
public class EngineNewModule {
    @Provides
    @Gasoline
    public Engine provideGasoline() {
        return new GasolineEngine();
    }

    @Provides
    @Diesel
    public Engine provideDiesel() {
        return new DieselEngine();
    }
}
