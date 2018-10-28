package com.cedro.cedroteste.cadastro.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import com.cedro.cedroteste.cadastro.CadastroMVP;
import com.cedro.cedroteste.cadastro.model.CadastroModel;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

@EBean
public class CadastroPresenter implements CadastroMVP.CadastroPresenter {

    private CadastroMVP.CadastroView cadastroView;

    @Bean
    protected CadastroModel cadastroModel;

    @RootContext
    protected Context mContext;

    @AfterInject
    public void init() {
        cadastroModel.setPresenter(this);
    }

    @Override
    public void setView(CadastroMVP.CadastroView cadastroView) {
        this.cadastroView = cadastroView;
    }

    @Override
    public void validarCadastro(EditText edtNome, EditText edtSenha, EditText edtUsuario) {
        String usuario = edtUsuario.getText().toString().toLowerCase();
        String nome = edtNome.getText().toString();
        String senha = edtSenha.getText().toString();

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

        if (nome.trim().equals("")) {
            edtNome.setError("Preencher Nome");
            edtNome.requestFocus();
            return;
        }

        cadastroModel.realizarCadastro(usuario, senha, nome);
    }

    @Override
    public void openLista() {
        new AlertDialog.Builder(mContext)
                .setTitle("Cadastro")
                .setMessage("Cadastro realizado com sucesso.")
                .setPositiveButton(android.R.string.ok,null)
                .show();
    }

    @Override
    public void exibirErro(String message, String[] erross) {
        new AlertDialog.Builder(mContext)
                .setTitle("Cadastro")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok,null)
                .show();
    }
}
