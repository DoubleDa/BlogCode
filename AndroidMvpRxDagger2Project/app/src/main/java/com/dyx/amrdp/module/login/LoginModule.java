package com.dyx.amrdp.module.login;

import com.dyx.amrdp.data.local.SPManager;
import com.dyx.amrdp.data.remote.ApiManager;
import com.dyx.amrdp.utils.ValidatorUtil;

import dagger.Module;
import dagger.Provides;

/**
 * Author：dayongxin
 * Function：
 */
@Module
public class LoginModule {
    private LoginView loginView;

    public LoginModule(LoginView loginView) {
        this.loginView = loginView;
    }

    @Provides
    LoginView providesLoginView() {
        return loginView;
    }


    @Provides
    ValidatorUtil providesValidatorUtil() {
        return new ValidatorUtil();
    }

    @Provides
    LoginPresenter providesLoginPresenter(ValidatorUtil validatorUtil, ApiManager apiManager, SPManager spManager) {
        return new LoginPresenter(loginView, validatorUtil, apiManager, spManager);
    }
}
