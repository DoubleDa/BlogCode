package com.dyx.amrdp.module.login;

import dagger.Subcomponent;

/**
 * Author：dayongxin
 * Function：
 */
@Subcomponent(modules = LoginModule.class)
public interface LoginComponent {
    LoginActivity inject(LoginActivity loginActivity);
}
