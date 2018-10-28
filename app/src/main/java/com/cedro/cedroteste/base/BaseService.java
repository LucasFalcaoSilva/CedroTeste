package com.cedro.cedroteste.base;

import android.util.Log;

import com.cedro.cedroteste.ServiceEnum;
import com.cedro.cedroteste.rest.domain.RetornoSO;

import java.util.concurrent.TimeUnit;

import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseService {

    protected static Retrofit retrofit;

    protected static Object retrofitCreate(Class aClass, String url) {
        okhttp3.OkHttpClient.Builder clientBuilder = new okhttp3.OkHttpClient().newBuilder();
        clientBuilder.readTimeout(30, TimeUnit.SECONDS);
        clientBuilder.connectTimeout(30, TimeUnit.SECONDS);

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("Log", message);
            }
        });
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        clientBuilder.addInterceptor(interceptor);
        retrofit = new Retrofit.Builder()
                .client(clientBuilder.build())
                .baseUrl("https://" + url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(aClass);
    }

    protected Callback<RetornoSO> getCallBackRetornoSO(final CallBackService<RetornoSO> callback) {
        return new Callback<RetornoSO>() {
            @Override
            public void onResponse(Call<RetornoSO> call, Response<RetornoSO> response) {
                RetornoSO retornoSO = null;

                if (response.isSuccessful())
                    retornoSO = response.body();
                else {

                    Converter<ResponseBody, RetornoSO> converter = retrofit.responseBodyConverter(RetornoSO.class, RetornoSO.class.getAnnotations());

                    try {
                        retornoSO = converter.convert(response.errorBody());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }

                ServiceEnum serviceEnum = ServiceEnum.getEnum(retornoSO.getType());

                if (serviceEnum == ServiceEnum.SUCESSO) {
                    callback.sucesso(retornoSO);
                } else {
                    callback.falha(retornoSO);
                }
            }

            @Override
            public void onFailure(Call<RetornoSO> call, Throwable t) {
                //TODO: Realizar tratamentos para falta de internet e indisponibilidade de serviço
            }
        };

    }
}
