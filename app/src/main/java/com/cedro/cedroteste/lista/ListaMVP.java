package com.cedro.cedroteste.lista;

import android.widget.EditText;

import com.cedro.cedroteste.lista.domain.SiteUsuario;
import com.cedro.cedroteste.lista.view.adapter.SitesAdapter;

import java.util.List;

public interface ListaMVP {

    interface ListaView {
        void iniciarGrid();

        void atualizarGrid(SitesAdapter sitesAdapter);
    }

    interface ListaPresenter {
        void setView(ListaMVP.ListaView listaView);

        void carregarSites();

        void atualizarGrid(List<SiteUsuario> sites);

        void validarSite(EditText edtUsuario, EditText edtSenha, EditText edtUrl);

        void erroAoCarregarLista();

        void erroAoInserirRegistro();

        void erroAoApagarRegistro();

        void realizarLogout();

    }

    interface ListaModel {
        void setPresenter(ListaMVP.ListaPresenter listaPresenter);

        void inserirRegistro(String usuario, String senha, String url);

        void obterTodosSites();

        void apagarRegistro(SiteUsuario siteUsuario);

        void limparSessao();
    }
}
