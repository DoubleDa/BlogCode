package com.dyx.aid2.bean;

import javax.inject.Inject;

/**
 * Author：dayongxin
 * Function：
 */
public class DieselEngine extends Engine {
    @Inject
    public DieselEngine() {
    }

    @Override
    public String work() {
        return "This is Diesel Engine!";
    }
}
