package com.idziak.cards.response;

import java.io.Serializable;
import java.util.List;

public class RegistrationResponse implements Serializable{
    public static final String OK = "ok";
    public static final String EXISTS = "exists";

    private List<String> fields;
    private String status = OK;

    public void setFields(List<String> fields) {
        status = EXISTS;
        this.fields = fields;
    }

    public List<String> getFields() {
        return fields;
    }

    public String getStatus() {
        return status;
    }
}
