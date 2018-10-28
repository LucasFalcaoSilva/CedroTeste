package com.cedro.cedroteste;

public enum ServiceEnum {
    ERROR("error"),
    SUCESSO("sucess");

    private String tipo;

    ServiceEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public static ServiceEnum getEnum(String tipo) {
        for (ServiceEnum serviceEnum : values())
            if (serviceEnum.getTipo().equals(tipo))
                return serviceEnum;

        return null;
    }
}
