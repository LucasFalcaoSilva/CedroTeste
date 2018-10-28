package com.cedro.cedroteste.rest.retrofit;

import com.cedro.cedroteste.rest.domain.CadastroSO;
import com.cedro.cedroteste.rest.domain.LoginSO;
import com.cedro.cedroteste.rest.domain.RetornoSO;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface CedroRest {

    @POST("/mobile/api/v2/register")
    Call<RetornoSO> enviarCadastro(@Body CadastroSO cadastroSO);

    @POST("/mobile/api/v2/login")
    Call<RetornoSO> validarLogin(@Body LoginSO cadastroSO);

}
