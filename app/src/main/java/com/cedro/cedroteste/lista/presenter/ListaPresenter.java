package com.cedro.cedroteste.lista.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import com.cedro.cedroteste.lista.ListaMVP;
import com.cedro.cedroteste.lista.domain.SiteUsuario;
import com.cedro.cedroteste.lista.model.ListaModel;
import com.cedro.cedroteste.lista.view.adapter.SitesAdapter;
import com.cedro.cedroteste.login.view.LoginActivity_;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

import java.util.List;

@EBean
public class ListaPresenter implements ListaMVP.ListaPresenter {

    private ListaMVP.ListaView listaView;

    @Bean
    protected ListaModel listaModel;

    @Bean
    protected SitesAdapter sitesAdapter;

    @RootContext
    protected Context mContext;

    @AfterInject
    public void init() {
        listaModel.setPresenter(this);
    }

    @Override
    public void setView(ListaMVP.ListaView listaView) {
        this.listaView = listaView;
    }

    @Override
    public void carregarSites() {
        listaModel.obterTodosSites();
    }

    @Override
    public void atualizarGrid(List<SiteUsuario> sites) {
        sitesAdapter.setSites(sites);
        sitesAdapter.setOnItemClickListener(new SitesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(final SiteUsuario siteUsuario) {

                new AlertDialog.Builder(mContext)
                        .setTitle("Deletar")
                        .setMessage("Deseja apagar item?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                listaModel.apagarRegistro(siteUsuario);
                            }
                        })
                        .setNegativeButton(android.R.string.no, null)
                        .show();

            }
        });
        listaView.atualizarGrid(sitesAdapter);
    }

    @Override
    public void validarSite(EditText edtUsuario, EditText edtSenha, EditText edtUrl) {
        String usuario = edtUsuario.getText().toString();
        String senha = edtSenha.getText().toString();
        String url = edtUrl.getText().toString();

        if (usuario.trim().equals("")) {
            edtUsuario.setError("Preencher Usuario");
            edtUsuario.requestFocus();
            return;
        }

        if (senha.trim().equals("")) {
            edtSenha.setError("Preencher Senha");
            edtSenha.requestFocus();
            return;
        }

        if (url.trim().equals("")) {
            edtUrl.setError("Preencher URL");
            edtUrl.requestFocus();
            return;
        }

        listaModel.inserirRegistro(usuario, senha, url);
    }

    @Override
    @UiThread
    public void erroAoCarregarLista() {
        new AlertDialog.Builder(mContext)
                .setTitle("ERRO")
                .setMessage("Erro ao Carregar a Lista")
                .setNegativeButton(android.R.string.ok, null)
                .show();
    }

    @Override
    @UiThread
    public void erroAoInserirRegistro() {
        new AlertDialog.Builder(mContext)
                .setTitle("ERRO")
                .setMessage("Erro ao inserir registro")
                .setNegativeButton(android.R.string.ok, null)
                .show();
    }

    @Override
    @UiThread
    public void erroAoApagarRegistro() {
        new AlertDialog.Builder(mContext)
                .setTitle("ERRO")
                .setMessage("Erro ao apagar registro")
                .setNegativeButton(android.R.string.ok, null)
                .show();
    }

    @Override
    public void realizarLogout() {
        new AlertDialog.Builder(mContext)
                .setTitle("Logoout")
                .setMessage("Deseja Realizar Logout?")
                .setNegativeButton(android.R.string.no, null)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listaModel.limparSessao();
                        LoginActivity_.
                                intent(mContext).
                                flags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK).
                                start();
                    }
                })
                .show();
    }

}
