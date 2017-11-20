package com.dyx.aid2.component;

import com.dyx.aid2.bean.FootBaller;
import com.dyx.aid2.module.FootBallModule;

import dagger.Component;

/**
 * Author：dayongxin
 * Function：
 */
@Component(modules = FootBallModule.class)
public interface FootBallComponent {
    FootBaller getFootBaller();
}
