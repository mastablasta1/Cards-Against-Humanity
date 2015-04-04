package com.idziak.cards;

import java.util.List;

public class AlreadyExistsException extends Exception{
    private final List<String> fields;

    public AlreadyExistsException(List<String> fields){
        this.fields = fields;
    }

    public List<String> getFields() {
        return fields;
    }
}
