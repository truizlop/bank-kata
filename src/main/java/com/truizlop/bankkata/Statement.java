package com.truizlop.bankkata;

import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;

public class Statement {

    private static final String STATEMENT_HEADER = "date | deposit | withdrawal | balance";
    private List<StatementLine> statementLineList;

    public Statement() {
        this.statementLineList = new LinkedList<>();
    }

    public void addLineContaining(Transaction transaction, double balance){
        statementLineList.add(0, new StatementLine(transaction, balance));
    }

    public void printTo(PrintStream printer) {
        printer.println(STATEMENT_HEADER);
        for (StatementLine line : statementLineList){
            line.printTo(printer);
        }
    }
}
