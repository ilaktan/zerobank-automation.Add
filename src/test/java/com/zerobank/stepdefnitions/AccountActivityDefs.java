package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityDefs {
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String expected) {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.onlineBankingLink.click();
        accountSummary.accountSummaryLink.click();

        AccountActivity accountActivity=new AccountActivity();

        if(expected.equals("Savings")){
            accountActivity.savingLink.click();


        }else if(expected.equals("Brokerage")){
            accountActivity.brokerageLink.click();

        }else if(expected.equals("Checking link")){
            accountActivity.checkingLink.click();

        }else if(expected.equals("Credit card")){
            accountActivity.creditCardLink.click();

        }else if(expected.equals("Loan link")){
            accountActivity.loanLink.click();
        }

    }
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedTitle) {

        if(expectedTitle.equals("Savings")){



            String accountSaving= Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[1]")).getText();;
           Assert.assertTrue(accountSaving.contains(expectedTitle));


        }else if(expectedTitle.equals("Credit Card")){

            String accountSaving= Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[5]")).getText();;
           Assert.assertTrue(accountSaving.contains(expectedTitle));


        }else if(expectedTitle.equals("Checking")){

            String accountSaving= Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[2]")).getText();;
            Assert.assertTrue(accountSaving.contains(expectedTitle));



        }else if(expectedTitle.equals("Brokerage")){

            String accountSaving= Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[6]")).getText();;
            Assert.assertTrue(accountSaving.contains(expectedTitle));



        }else if(expectedTitle.equals("loan")){

            String accountSaving= Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[4]")).getText();;
            Assert.assertTrue(accountSaving.contains(expectedTitle));



        }else{
            String accountSaving=Driver.get().findElement(By.xpath("//select")).getText();;
            Assert.assertTrue(accountSaving.contains(expectedTitle));

        }


    }

    @When("the user navigate Online Banking, Account Activity")
    public void the_user_navigate_Online_Banking_Account_Activity() {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.onlineBankingLink.click();
        AccountActivity accountActivity=new AccountActivity();
        accountActivity.accountActivityLink.click();

    }

    @Then("the user should be able to see following options")
    public void the_user_should_be_able_to_see_following_options(List<String> menuOptions) {

        AccountActivity accountActivity=new AccountActivity();
        List<String> actualOptions = BrowserUtils.getElementsText(accountActivity.dropdownList);

        Assert.assertEquals(menuOptions,actualOptions);


    }

    @Then("the user should be able to see following column names")
    public void the_user_should_be_able_to_see_following_column_names(List<String> menuOptions) {
        AccountActivity accountActivity=new AccountActivity();
        List<String> actualOptions = BrowserUtils.getElementsText(accountActivity.transactionColumn);

        Assert.assertEquals(menuOptions,actualOptions);

    }

}
