package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AccountSummaryDefs {

    @When("the user navigate Online Banking, Account Summary")
    public void the_user_navigate_Online_Banking_Account_Summary() {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.onlineBankingLink.click();
        accountSummary.accountSummaryLink.click();

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String expected) {


        Assert.assertEquals(expected,Driver.get().getTitle());


    }

    @Then("the user should be able to see following account types")
    public void the_user_should_be_able_to_see_following_account_types(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

    @Then("the user should be able to see following credit accounts columns")
    public void the_user_should_be_able_to_see_following_credit_accounts_columns(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }

}
