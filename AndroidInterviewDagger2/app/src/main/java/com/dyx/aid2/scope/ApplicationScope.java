package com.dyx.aid2.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Author：dayongxin
 * Function：
 */
@Scope
@Retention(RUNTIME)
public @interface ApplicationScope {
}
