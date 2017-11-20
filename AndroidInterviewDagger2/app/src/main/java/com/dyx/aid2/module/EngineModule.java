package com.dyx.aid2.module;

import com.dyx.aid2.bean.DieselEngine;
import com.dyx.aid2.bean.Engine;
import com.dyx.aid2.bean.GasolineEngine;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

/**
 * Author：dayongxin
 * Function：
 */
@Module
public class EngineModule {
    @Provides
    @Named("Gasoline")
    public Engine provideGasoline() {
        return new GasolineEngine();
    }


    @Provides
    @Named("Diesel")
    public Engine provideDiesel() {
        return new DieselEngine();
    }
}
