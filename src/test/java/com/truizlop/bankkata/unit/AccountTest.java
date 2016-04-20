package com.truizlop.bankkata.unit;

import com.truizlop.bankkata.Account;
import com.truizlop.bankkata.Statement;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.truizlop.bankkata.builder.TransactionBuilder.aTransaction;
import static org.mockito.Mockito.verify;


@RunWith(MockitoJUnitRunner.class)
public class AccountTest {

    private static final double ANY_AMOUNT = 1234.56;
    private static final String ANY_DATE = "23/02/2015";

    @Mock Statement statement;
    private Account account;

    @Before
    public void setup(){
        account = new Account(statement);
    }

    @Test
    public void shouldAddADepositTransactionToStatement(){
        account.deposit(ANY_AMOUNT, ANY_DATE);

        verify(statement).addLineContaining(
                aTransaction()
                        .withAmount(ANY_AMOUNT)
                        .onDate(ANY_DATE).build(),
                ANY_AMOUNT);
    }

    @Test
    public void shouldAddAWithdrawalTransactionToStatement(){
        account.withdraw(ANY_AMOUNT, ANY_DATE);

        verify(statement).addLineContaining(
                aTransaction()
                        .withAmount(-ANY_AMOUNT)
                        .onDate(ANY_DATE).build(),
                -ANY_AMOUNT
        );
    }

    @Test
    public void shouldUpdateBalanceAfterSeveralTransactions(){
        account.deposit(1000, ANY_DATE);
        account.withdraw(300, ANY_DATE);

        verify(statement).addLineContaining(
                aTransaction()
                        .withAmount(1000)
                        .onDate(ANY_DATE).build(),
                1000
        );

        verify(statement).addLineContaining(
                aTransaction()
                        .withAmount(-300)
                        .onDate(ANY_DATE).build(),
                700
        );
    }
}
