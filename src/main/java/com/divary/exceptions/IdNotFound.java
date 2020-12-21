package com.divary.exceptions;

public class IdNotFound extends RuntimeException{

    public IdNotFound(String object, String id) {
        super(object + " " + id + " not found");
    }
}
