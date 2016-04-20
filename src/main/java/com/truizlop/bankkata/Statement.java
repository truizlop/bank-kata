package com.truizlop.bankkata;

import java.io.PrintStream;

public class Statement {

    private static final String STATEMENT_HEADER = "date | deposit | withdrawal | balance";

    public void addLineContaining(Transaction transaction, double balance){

    }

    public void printTo(PrintStream printer) {
        printer.println(STATEMENT_HEADER);
    }
}
