package com.truizlop.bankkata.unit;

import com.truizlop.bankkata.StatementLine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static com.truizlop.bankkata.builder.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementLineTest {

    @Mock PrintStream printer;

    @Test
    public void shouldPrintDeposit(){
        StatementLine line = new StatementLine(
                aTransaction().withAmount(1000).onDate("01/02/2003").build(), 800);

        line.printTo(printer);

        verify(printer).println("01/02/2003 | 1000.00 | - | 800.00");
    }

    @Test
    public void shouldPrintWithdrawal(){
        StatementLine line = new StatementLine(
                aTransaction().withAmount(-500).onDate("01/02/2003").build(), -500
        );
        line.printTo(printer);

        verify(printer).println("01/02/2003 | - | 500.00 | -500.00");
    }

}
