package com.dyx.aid2.bean;

import javax.inject.Inject;

/**
 * Author：dayongxin
 * Function：汽油
 */
public class GasolineEngine extends Engine {
    @Inject
    public GasolineEngine() {
    }

    @Override
    public String work() {
        return "This is Gasoline Engine!";
    }
}
