package com.cedro.cedroteste.base;

public interface CallBackService<T> {
    void sucesso(T retorno);
    void falha(T retorno);
}
