package com.cedro.cedroteste.lista.domain;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import android.util.Log;

@Entity(tableName = "SITES")
public class SiteUsuario {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private Long id;
    @ColumnInfo(name = "usuario")
    private String usuario;
    @ColumnInfo(name = "senha")
    private String senha;
    @ColumnInfo(name = "site")
    private String site;

    @ColumnInfo(name = "emailToken")
    private String emailToken;

    public SiteUsuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getEmailToken() {
        return emailToken;
    }

    public void setEmailToken(String emailToken) {
        this.emailToken = emailToken;
    }

    public static SiteUsuario createSiteUsuario(String usuario, String senha, String url, String emailToken) {
        SiteUsuario siteUsuario = new SiteUsuario();
        siteUsuario.setSenha(senha);
        siteUsuario.setSite(url);
        siteUsuario.setUsuario(usuario);
        siteUsuario.setEmailToken(emailToken);
        return siteUsuario;
    }
}
