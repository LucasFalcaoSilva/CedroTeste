package com.cedro.cedroteste.cadastro.model;

import com.cedro.cedroteste.base.CallBackService;
import com.cedro.cedroteste.cadastro.CadastroMVP;
import com.cedro.cedroteste.rest.CedroWService;
import com.cedro.cedroteste.rest.domain.CadastroSO;
import com.cedro.cedroteste.rest.domain.LoginSO;
import com.cedro.cedroteste.rest.domain.RetornoSO;
import com.cedro.cedroteste.session.Session;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

@EBean
public class CadastroModel implements CadastroMVP.CadastroModel {

    private CadastroMVP.CadastroPresenter cadastroPresenter;

    @Bean
    protected CedroWService cedroService;

    @Bean
    protected Session mSession;

    @Override
    public void setPresenter(CadastroMVP.CadastroPresenter cadastroPresenter) {
        this.cadastroPresenter = cadastroPresenter;
    }

    @Override
    public void realizarCadastro(final String usuario, String senha, String nome) {
        CadastroSO cadastroSO = CadastroSO.createCadastroSO(usuario, senha,nome);

        cedroService.realizarCadastro(cadastroSO, new CallBackService<RetornoSO>() {
            @Override
            public void sucesso(RetornoSO retornoSO) {
                mSession.setToken(retornoSO.getToken());
                mSession.setEmail(usuario);
                cadastroPresenter.openLista();
            }

            @Override
            public void falha(RetornoSO retornoSO) {
                cadastroPresenter.exibirErro(retornoSO.getMessage(), retornoSO.getErross());
            }
        });
    }
}
