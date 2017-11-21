package com.dyx.amrdp.di;

import android.app.Application;

import com.dyx.amrdp.data.local.SPManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Author：dayongxin
 * Function：
 */
@Module
public class AppModule {
    private Application application;

    public AppModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    public SPManager providesSPManager() {
        return new SPManager(application);
    }
}
