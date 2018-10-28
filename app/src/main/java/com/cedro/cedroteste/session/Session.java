package com.cedro.cedroteste.session;

import org.androidannotations.annotations.EBean;


@EBean(scope = EBean.Scope.Singleton)
public class Session {

    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
