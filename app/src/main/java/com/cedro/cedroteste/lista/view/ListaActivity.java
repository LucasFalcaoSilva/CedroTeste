package com.cedro.cedroteste.lista.view;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.cedro.cedroteste.R;
import com.cedro.cedroteste.base.BaseActivity;
import com.cedro.cedroteste.lista.ListaMVP;
import com.cedro.cedroteste.lista.presenter.ListaPresenter;
import com.cedro.cedroteste.lista.view.adapter.SitesAdapter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_lista)
public class ListaActivity extends BaseActivity implements ListaMVP.ListaView {

    @ViewById(R.id.edt_senha)
    protected EditText edtSenha;

    @ViewById(R.id.edt_usuario)
    protected EditText edtUsuario;

    @ViewById(R.id.edt_url)
    protected EditText edtUrl;

    @ViewById(R.id.rv_lista_urls)
    protected RecyclerView rvListaUrl;

    @Bean
    protected ListaPresenter listaPresenter;

    @AfterInject
    public void init() {
        super.carregarTitulo("Senhas sites");
        listaPresenter.setView(this);
        super.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listaPresenter.realizarLogout();
            }
        });
    }

    @AfterViews
    public void carregar(){
        iniciarGrid();
        listaPresenter.carregarSites();
    }

    @Click(R.id.btn_inserir)
    protected void callInserir(){
        listaPresenter.validarSite(edtUsuario,edtSenha,edtUrl);
    }

    @Override
    public void iniciarGrid() {
        rvListaUrl.setLayoutManager(new LinearLayoutManager(this));
        rvListaUrl.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        rvListaUrl.setHasFixedSize(true);
    }

    @Override
    @UiThread
    public void atualizarGrid(SitesAdapter sitesAdapter) {
        rvListaUrl.setAdapter(sitesAdapter);
        sitesAdapter.notifyDataSetChanged();
    }
}
