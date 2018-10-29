package com.cedro.cedroteste.repository;

import android.content.Context;

import com.cedro.cedroteste.base.CallBackGeneric;
import com.cedro.cedroteste.lista.domain.SiteUsuario;
import com.cedro.cedroteste.repository.dao.SiteUsuarioDAO;
import com.cedro.cedroteste.repository.db.DatabaseManager;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;
import org.androidannotations.annotations.RootContext;

import java.util.List;

@EBean
public class SiteRepository {

    @RootContext
    protected Context mContext;

    private SiteUsuarioDAO siteUsuarioDAO;

    @AfterInject
    protected void init() {
        siteUsuarioDAO = DatabaseManager.getInstance(mContext).getSiteUsuarioDAO();
    }

    @Background
    public void inserirSite(CallBackGeneric callBack, SiteUsuario siteUsuario) {
        try {
            siteUsuarioDAO.insert(siteUsuario);

            if (callBack != null)
                callBack.callBackSuccess(null);

        } catch (Exception e) {
            e.printStackTrace();
            if (callBack != null)
                callBack.callBackError(null);
        }
    }

    @Background
    public void apagarSite(CallBackGeneric callBack, SiteUsuario siteUsuario) {
        try {
            siteUsuarioDAO.delete(siteUsuario);

            if (callBack != null)
                callBack.callBackSuccess(null);

        } catch (Exception e) {
            e.printStackTrace();
            if (callBack != null)
                callBack.callBackError(null);
        }
    }


    @Background
    public void obterSiteUsuario(CallBackGeneric callBack, Long id) {
        try {
            SiteUsuario siteUsuario;

            siteUsuario = siteUsuarioDAO.getById(id);

            if (callBack != null)
                callBack.callBackSuccess(siteUsuario);

        } catch (Exception ex) {
            if (callBack != null)
                callBack.callBackError(null);
        }
    }

    @Background
    public void obterSiteUsuarioLogado(CallBackGeneric callBack, String emailToken) {
        try {
            List<SiteUsuario> siteUsuario;

            siteUsuario = siteUsuarioDAO.getByEmailToken(emailToken);

            if (callBack != null)
                callBack.callBackSuccess(siteUsuario);

        } catch (Exception ex) {
            if (callBack != null)
                callBack.callBackError(null);
        }
    }

    @Background
    public void obterTodosSiteUsuario(CallBackGeneric callBack) {
        try {
            List<SiteUsuario> siteUsuarios;

            siteUsuarios = siteUsuarioDAO.getAll();

            if (callBack != null)
                callBack.callBackSuccess(siteUsuarios);

        } catch (Exception ex) {
            if (callBack != null)
                callBack.callBackError(null);
        }
    }

}
