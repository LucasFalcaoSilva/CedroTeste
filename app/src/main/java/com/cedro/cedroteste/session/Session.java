package com.cedro.cedroteste.session;

import org.androidannotations.annotations.EBean;


@EBean(scope = EBean.Scope.Singleton)
public class Session {

    private String token;

    private String email;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void clearSession() {
        email = null;
        token = null;
    }
}
