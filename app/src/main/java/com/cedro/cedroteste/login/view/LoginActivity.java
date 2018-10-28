package com.cedro.cedroteste.login.view;

import android.widget.EditText;

import com.cedro.cedroteste.R;
import com.cedro.cedroteste.base.BaseActivity;
import com.cedro.cedroteste.login.LoginMVP;
import com.cedro.cedroteste.login.presenter.LoginPresenter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_login)
public class LoginActivity extends BaseActivity implements LoginMVP.LoginView {

    @ViewById(R.id.edt_senha)
    protected EditText edtSenha;

    @ViewById(R.id.edt_usuario)
    protected EditText edtUsuario;

    @Bean
    protected LoginPresenter loginPresenter;

    @AfterInject
    public void init() {
        super.carregarTitulo("Login Cedro");
        loginPresenter.setView(this);
    }

    @Click(R.id.btn_acessar)
    public void callAcessar() {
        loginPresenter.realizarLogin(edtUsuario, edtSenha);
    }

    @Click(R.id.btn_cadastrar)
    public void callCadastrar() {
        loginPresenter.openCadastro();
    }
}
