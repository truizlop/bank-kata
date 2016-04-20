package com.truizlop.bankkata;

import java.io.PrintStream;
import java.text.DecimalFormat;

public class Transaction {

    private static final String SEPARATOR = " | ";
    private static final String EMPTY_VALUE = "-";
    private DecimalFormat decimalFormat = new DecimalFormat("#.00");

    private final double amount;
    private final String date;

    public Transaction(double amount, String date) {
        this.amount = amount;
        this.date = date;
    }

    public void printTo(PrintStream printer, double balance) {
        printer.println(date + SEPARATOR + stringForAmount(amount) + SEPARATOR + EMPTY_VALUE + SEPARATOR + stringForAmount(balance));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Transaction that = (Transaction) o;

        if (Double.compare(that.amount, amount) != 0) return false;
        return date != null ? date.equals(that.date) : that.date == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(amount);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "amount=" + amount +
                ", date='" + date + '\'' +
                '}';
    }

    private String stringForAmount(double amount){
        return decimalFormat.format(Math.abs(amount)).replace(",", ".");
    }
}
