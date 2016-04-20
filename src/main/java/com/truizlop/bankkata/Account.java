package com.truizlop.bankkata;

import java.io.PrintStream;

public class Account {

    private Statement statement;
    private double balance;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(double amount, String date) {
        addTransaction(amount, date);
    }

    public void withdraw(double amount, String date) {
        addTransaction(-amount, date);
    }

    public void printStatement(PrintStream printer) {

    }

    private void addTransaction(double amount, String date) {
        double newBalance = balance + amount;
        statement.addLineContaining(new Transaction(amount, date), newBalance);
        balance = newBalance;
    }
}
