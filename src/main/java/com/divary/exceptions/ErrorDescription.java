package com.divary.exceptions;

public class ErrorDescription extends RuntimeException{

    public ErrorDescription(String description, String debitCreditStatus) {
        super("in " + debitCreditStatus + "'" + description + "' cannot found");
    }
}
