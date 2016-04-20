package com.truizlop.bankkata.unit;

import com.truizlop.bankkata.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.PrintStream;

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
}
