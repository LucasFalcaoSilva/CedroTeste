package com.cedro.cedroteste.base;

public interface CallBackGeneric<T> {

    void callBackSuccess(T response);

    void callBackError(T response);
}