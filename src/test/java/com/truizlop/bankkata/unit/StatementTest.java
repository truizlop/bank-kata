package com.truizlop.bankkata.unit;

import com.truizlop.bankkata.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

import static com.truizlop.bankkata.builder.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.inOrder;
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
    public void shouldPrintInTheRightOrder(){
        statement.addLineContaining(
                aTransaction().withAmount(1000).onDate("01/02/2003").build(), 1000
        );
        statement.addLineContaining(
                aTransaction().withAmount(-300).onDate("02/02/2003").build(), 700
        );
        statement.printTo(printer);

        InOrder inOrder = inOrder(printer);
        inOrder.verify(printer).println("date | deposit | withdrawal | balance");
        inOrder.verify(printer).println("02/02/2003 | - | 300.00 | 700.00");
        inOrder.verify(printer).println("01/02/2003 | 1000.00 | - | 1000.00");
    }
}
