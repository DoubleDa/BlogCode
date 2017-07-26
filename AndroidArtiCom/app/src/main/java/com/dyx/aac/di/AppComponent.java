package com.dyx.aac.di;

import javax.inject.Singleton;

import dagger.Component;

/**
 * project name：AndroidArtiCom
 * class describe：
 * create person：dayongxin
 * create time：2017/6/22 下午5:13
 * alter person：dayongxin
 * alter time：2017/6/22 下午5:13
 * alter remark：
 */
@Singleton
@Component(modules = {AppModule.class, MainActivityModule.class})
public interface AppComponent {
}
