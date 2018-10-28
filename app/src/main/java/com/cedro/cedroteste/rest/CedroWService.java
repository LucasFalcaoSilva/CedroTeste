package com.cedro.cedroteste.rest;

import com.cedro.cedroteste.base.BaseService;
import com.cedro.cedroteste.base.CallBackService;
import com.cedro.cedroteste.rest.domain.CadastroSO;
import com.cedro.cedroteste.rest.domain.LoginSO;
import com.cedro.cedroteste.rest.domain.RetornoSO;
import com.cedro.cedroteste.rest.retrofit.CedroRest;

import org.androidannotations.annotations.AfterInject;
import org.androidannotations.annotations.EBean;

import retrofit2.Call;

@EBean
public class CedroWService extends BaseService {

    private CedroRest cedroRest;

    @AfterInject
    protected void iniciar() {
        cedroRest = (CedroRest) retrofitCreate(CedroRest.class, "dev.people.com.ai");
    }

    public void validarLogin(LoginSO loginSO, final CallBackService<RetornoSO> callback) {

        Call<RetornoSO> call = cedroRest.validarLogin(loginSO);

        call.enqueue(getCallBackRetornoSO(callback));
    }

    public void realizarCadastro(CadastroSO cadastroSO, final CallBackService<RetornoSO> callback) {

        Call<RetornoSO> call = cedroRest.enviarCadastro(cadastroSO);

        call.enqueue(getCallBackRetornoSO(callback));

    }
}
