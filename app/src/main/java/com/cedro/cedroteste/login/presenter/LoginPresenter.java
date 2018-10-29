package com.cedro.cedroteste.login.presenter;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import com.cedro.cedroteste.cadastro.view.CadastroActivity_;
import com.cedro.cedroteste.lista.view.ListaActivity_;
import com.cedro.cedroteste.login.LoginMVP;
import com.cedro.cedroteste.login.model.LoginModel;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;
import org.androidannotations.annotations.UiThread;

@EBean
public class LoginPresenter implements LoginMVP.LoginPresenter {

    private LoginMVP.LoginView loginView;

    @Bean
    protected LoginModel loginModel;

    @RootContext
    protected Context mContext;

    @AfterInject
    public void init() {
        loginModel.sePresenter(this);
    }

    @Override
    public void setView(LoginMVP.LoginView loginView) {
        this.loginView = loginView;
    }

    @Override
    public void realizarLogin(EditText edtUsuario, EditText edtSenha) {
        String usuario = edtUsuario.getText().toString().toLowerCase();
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

        loginModel.validarLogin(usuario, senha);
    }

    @Override
    @UiThread
    public void openLista() {
        new AlertDialog.Builder(mContext)
                .setTitle("Login")
                .setMessage("Login Realizado com sucesso")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        ListaActivity_.intent(mContext).start();
                    }
                })
                .show();
    }

    @Override
    public void openCadastro() {
        CadastroActivity_.intent(mContext).start();
    }

    @Override
    @UiThread
    public void exibirErro(String message, String[] erross) {
        new AlertDialog.Builder(mContext)
                .setTitle("Erro")
                .setMessage(message)
                .setPositiveButton(android.R.string.ok, null)
                .show();
    }
}
