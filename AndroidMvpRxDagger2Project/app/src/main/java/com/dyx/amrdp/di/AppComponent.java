package com.dyx.amrdp.di;

import com.dyx.amrdp.module.login.LoginComponent;
import com.dyx.amrdp.module.login.LoginModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Author：dayongxin
 * Function：
 */
@Singleton
@Component(modules = {ApiModule.class, AppModule.class})
public interface AppComponent {
    LoginComponent plus(LoginModule loginModule);
}
