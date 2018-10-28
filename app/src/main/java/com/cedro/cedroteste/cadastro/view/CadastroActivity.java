package com.cedro.cedroteste.cadastro.view;

import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import com.cedro.cedroteste.R;
import com.cedro.cedroteste.base.BaseActivity;
import com.cedro.cedroteste.cadastro.CadastroMVP;
import com.cedro.cedroteste.cadastro.presenter.CadastroPresenter;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Bean;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

@EActivity(R.layout.activity_cadastro)
public class CadastroActivity extends BaseActivity implements CadastroMVP.CadastroView {

    @Bean
    protected CadastroPresenter cadastroPresenter;

    @ViewById(R.id.edt_senha)
    protected EditText edtSenha;

    @ViewById(R.id.edt_usuario)
    protected EditText edtUsuario;

    @ViewById(R.id.edt_nome)
    protected EditText edtNome;

    @AfterInject
    public void init() {
        super.carregarTitulo("Cadastro Usuario");
        cadastroPresenter.setView(this);
    }

    @Click(R.id.btn_cadastrar)
    protected void callCadastrar() {
        cadastroPresenter.validarCadastro(edtNome, edtSenha, edtUsuario);
    }

}
