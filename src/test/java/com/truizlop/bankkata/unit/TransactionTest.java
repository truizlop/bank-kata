package com.truizlop.bankkata.unit;

import com.truizlop.bankkata.Transaction;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsEqual.equalTo;

public class TransactionTest {

    private static final double ANY_AMOUNT = 1234.56;
    private static final String ANY_DATE = "01/01/2001";

    @Test
    public void shouldBeEqualToAnotherTransactionWithSameAmountAndDate(){
        Transaction t1 = new Transaction(ANY_AMOUNT, ANY_DATE);
        Transaction t2 = new Transaction(ANY_AMOUNT, ANY_DATE);

        assertThat(t1, is(equalTo(t2)));
    }
}
