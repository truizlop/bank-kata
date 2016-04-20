package com.truizlop.bankkata.acceptance;

import com.truizlop.bankkata.Account;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.mockito.InOrder;

import java.io.PrintStream;
import java.util.List;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;

public class PrintStatementSteps {

    private Account account;
    private PrintStream printer;

    @Given("the user has an empty account")
    public void theUserHasAnEmptyAccount(){
        account = new Account();
        printer = mock(PrintStream.class);
    }

    @When("she makes a deposit of $amount on $date")
    public void sheMakesADepositOfAmountOnDate(double amount, String date){
        account.deposit(amount, date);
    }

    @When("she makes a withdrawal of $amount on $date")
    public void sheMakesAWithdrawalOfAmountOnDate(double amount, String date){
        account.withdraw(amount, date);
    }

    @Then("she should see a statement like $result")
    public void sheShouldSeeAStatementLike(List<String> result){
        account.printStatement(printer);

        InOrder inOrder = inOrder(printer);
        for(String line : result){
            inOrder.verify(printer).println(line);
        }
        inOrder.verifyNoMoreInteractions();
    }

}
