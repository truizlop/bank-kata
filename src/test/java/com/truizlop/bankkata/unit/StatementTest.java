package com.truizlop.bankkata.unit;

import com.truizlop.bankkata.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static com.truizlop.bankkata.builder.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class StatementTest {

    private Statement statement;
    @Mock PrintStream printer;

    @Before
    public void setup(){
        statement = new Statement();
    }

    @Test
    public void shouldPrintHeaderWhenItIsEmpty(){
        statement.printTo(printer);

        verify(printer).println("date | deposit | withdrawal | balance");
    }

    @Test
    public void shouldPrintDeposit(){
        statement.addLineContaining(
                aTransaction().withAmount(1000).onDate("01/02/2003").build(), 1000
        );
        statement.printTo(printer);

        verify(printer).println("01/02/2003 | 1000.00 | - | 1000.00");
    }

    @Test
    public void shouldPrintWithdrawals(){
        statement.addLineContaining(
                aTransaction().withAmount(-500).onDate("01/02/2003").build(), -500
        );
        statement.printTo(printer);

        verify(printer).println("01/02/2003 | - | 500.00 | -500.00");
    }
}
