package com.truizlop.bankkata;

import java.io.PrintStream;

public class Account {

    private Statement statement;

    public Account(Statement statement) {
        this.statement = statement;
    }

    public void deposit(double amount, String date) {
        statement.addLineContaining(new Transaction(amount, date), amount);
    }

    public void withdraw(double amount, String date) {
        statement.addLineContaining(new Transaction(-amount, date), -amount);
    }

    public void printStatement(PrintStream printer) {

    }
}
