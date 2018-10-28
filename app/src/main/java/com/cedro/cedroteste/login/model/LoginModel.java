package com.cedro.cedroteste.login.model;

import com.cedro.cedroteste.base.CallBackService;
import com.cedro.cedroteste.login.LoginMVP;
import com.cedro.cedroteste.rest.CedroWService;
import com.cedro.cedroteste.rest.domain.LoginSO;
import com.cedro.cedroteste.rest.domain.RetornoSO;
import com.cedro.cedroteste.session.Session;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class LoginModel implements LoginMVP.LoginModel {

    private LoginMVP.LoginPresenter loginPresenter;

    @Bean
    protected CedroWService cedroService;

    @Bean
    protected Session mSession;

    @Override
    public void sePresenter(LoginMVP.LoginPresenter loginPresenter) {
        this.loginPresenter = loginPresenter;
    }

    @Override
    @Background
    public void validarLogin(String usuario, String senha) {
        LoginSO loginSO = LoginSO.createLoginSO(usuario, senha);

        cedroService.validarLogin(loginSO, new CallBackService<RetornoSO>() {
            @Override
            public void sucesso(RetornoSO retornoSO) {
                mSession.setToken(retornoSO.getToken());
                loginPresenter.openLista();
            }

            @Override
            public void falha(RetornoSO retornoSO) {
                loginPresenter.exibirErro(retornoSO.getMessage(), retornoSO.getErross());
            }
        });
    }


}
