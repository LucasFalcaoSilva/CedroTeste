package com.cedro.cedroteste.rest.domain;

public class CadastroSO {

    private String email;
    private String password;
    private String name;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return password;
    }

    public void setSenha(String senha) {
        this.password = senha;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static CadastroSO createCadastroSO(String usuario, String senha, String nome) {
        CadastroSO cadastroSO = new CadastroSO();
        cadastroSO.setEmail(usuario);
        cadastroSO.setName(nome);
        cadastroSO.setSenha(senha);

        return cadastroSO;
    }
}
