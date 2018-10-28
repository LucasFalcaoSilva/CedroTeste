package com.cedro.cedroteste.cadastro;

import android.widget.EditText;

public interface CadastroMVP {
    interface CadastroView {

    }

    interface CadastroPresenter {
        void setView(CadastroMVP.CadastroView  cadastroView);

        void validarCadastro(EditText edtNome, EditText edtSenha, EditText edtUsuario);

        void openLista();

        void exibirErro(String message, String[] erross);

    }

    interface CadastroModel {
        void setPresenter(CadastroMVP.CadastroPresenter cadastroPresenter);

        void realizarCadastro(String usuario, String senha,String nome);
    }

}
