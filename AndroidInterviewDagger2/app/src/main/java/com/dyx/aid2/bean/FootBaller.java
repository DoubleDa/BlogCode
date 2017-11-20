package com.dyx.aid2.bean;

import javax.inject.Inject;

/**
 * Author：dayongxin
 * Function：
 */
public class FootBaller {
    @Inject
    public FootBaller() {
    }

    public String kickTheBall() {
        return "I am kick the ball!";
    }
}
