package com.cedro.cedroteste.rest.domain;

public class RetornoSO {

    private String type;
    private String message;
    private String erross[];
    private String token;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String[] getErross() {
        return erross;
    }

    public void setErross(String[] erross) {
        this.erross = erross;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
