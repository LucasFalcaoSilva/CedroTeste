package com.cedro.cedroteste.login;

import android.widget.EditText;

public interface LoginMVP {
    interface LoginView{

    }
    interface LoginPresenter{
        void setView(LoginMVP.LoginView loginView);

        void openCadastro();

        void realizarLogin(EditText usuario, EditText senha);

        void openLista();

        void exibirErro(String message, String[] erross);
    }
    interface LoginModel{
        void sePresenter(LoginMVP.LoginPresenter loginPresenter);

        void validarLogin(String usuario, String senha);
    }
}
