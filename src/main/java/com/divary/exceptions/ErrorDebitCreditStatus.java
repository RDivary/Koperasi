package com.divary.exceptions;

public class ErrorDebitCreditStatus extends RuntimeException{

    public ErrorDebitCreditStatus(String debitCreditStatus) {
        super("debit credit can not '" + debitCreditStatus + "', Debit Credit must 'C' or 'D'");
    }
}
