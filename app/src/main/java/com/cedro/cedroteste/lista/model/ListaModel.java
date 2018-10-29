package com.cedro.cedroteste.lista.model;

import com.cedro.cedroteste.base.CallBackGeneric;
import com.cedro.cedroteste.lista.ListaMVP;
import com.cedro.cedroteste.lista.domain.SiteUsuario;
import com.cedro.cedroteste.repository.SiteRepository;
import com.cedro.cedroteste.session.Session;

import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;

import java.util.List;

@EBean
public class ListaModel implements ListaMVP.ListaModel {

    private ListaMVP.ListaPresenter listaPresenter;

    @Bean
    protected SiteRepository siteRepository;

    @Bean
    protected Session mSession;

    @Override
    public void setPresenter(ListaMVP.ListaPresenter listaPresenter) {
        this.listaPresenter = listaPresenter;
    }

    @Override
    public void inserirRegistro(String usuario, String senha, String url) {
        CallBackGeneric callBackGeneric = new CallBackGeneric() {
            @Override
            public void callBackSuccess(Object response) {
                listaPresenter.carregarSites();
            }

            @Override
            public void callBackError(Object response) {
                listaPresenter.erroAoInserirRegistro();
            }
        };

        SiteUsuario siteUsuario = SiteUsuario.createSiteUsuario(usuario, senha, url, mSession.getEmail());
        siteRepository.inserirSite(callBackGeneric, siteUsuario);
    }

    @Override
    public void apagarRegistro(SiteUsuario siteUsuario) {
        CallBackGeneric callBackGeneric = new CallBackGeneric() {
            @Override
            public void callBackSuccess(Object response) {
                listaPresenter.carregarSites();
            }

            @Override
            public void callBackError(Object response) {
                listaPresenter.erroAoApagarRegistro();
            }
        };

        siteRepository.apagarSite(callBackGeneric, siteUsuario);
    }

    @Override
    public void limparSessao() {
        mSession.clearSession();
    }


    @Override
    public void obterTodosSites() {

        CallBackGeneric callBackGeneric = new CallBackGeneric() {
            @Override
            public void callBackSuccess(Object response) {
                List<SiteUsuario> siteUsuarioList = (List<SiteUsuario>) response;
                listaPresenter.atualizarGrid(siteUsuarioList);
            }

            @Override
            public void callBackError(Object response) {
                listaPresenter.erroAoCarregarLista();
            }
        };

        siteRepository.obterSiteUsuarioLogado(callBackGeneric, mSession.getEmail());
    }
}
