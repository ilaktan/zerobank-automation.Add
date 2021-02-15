package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

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
    public void the_user_should_be_able_to_see_following_account_types(List<String> menuOptions) {


        AccountSummary accountSummary=new AccountSummary();



        List<String> actualOptions = BrowserUtils.getElementsText(accountSummary.menuOptions);

        Assert.assertEquals(menuOptions,actualOptions);

    }

    @Then("the user should be able to see following credit accounts columns")
    public void the_user_should_be_able_to_see_following_credit_accounts_columns(List<String> menuOptions) {
        AccountSummary accountSummary=new AccountSummary();

        List<String> actualOptions = BrowserUtils.getElementsText(accountSummary.CreditAccountTable);

        Assert.assertEquals(menuOptions,actualOptions);

    }

}
