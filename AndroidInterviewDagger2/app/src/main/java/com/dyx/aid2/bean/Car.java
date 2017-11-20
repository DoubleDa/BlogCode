package com.dyx.aid2.bean;

import com.dyx.aid2.anno.Gasoline;

import javax.inject.Inject;

/**
 * Author：dayongxin
 * Function：
 */
public class Car {
    private Engine engine;

    @Inject
    public Car(@Gasoline Engine engine) {
        this.engine = engine;
    }

    public String run() {
        return engine.work();
    }
}
