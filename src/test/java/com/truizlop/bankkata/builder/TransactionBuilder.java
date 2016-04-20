package com.truizlop.bankkata.builder;

import com.truizlop.bankkata.Transaction;

public class TransactionBuilder {

    public static TransactionBuilder aTransaction(){
        return new TransactionBuilder();
    }

    private double amount;
    private String date;

    public TransactionBuilder() {}

    public TransactionBuilder withAmount(double amount) {
        this.amount = amount;
        return this;
    }

    public TransactionBuilder onDate(String date) {
        this.date = date;
        return this;
    }

    public Transaction build(){
        return new Transaction(amount, date);
    }
}
