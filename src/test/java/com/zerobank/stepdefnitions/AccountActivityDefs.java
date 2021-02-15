package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

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


            String accountSaving= Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=1']")).getText();;
            Assert.assertTrue(accountSaving.contains(expectedTitle));


        }else if(expectedTitle.equals("Credit Card")){

            Driver.get().findElements(By.xpath("//select['aa_accountId']//option")).get(5).isSelected();



        }else if(expectedTitle.equals("Checking")){

            Driver.get().findElements(By.xpath("//select['aa_accountId']//option")).get(2).isSelected();



        }else if(expectedTitle.equals("loan")){

            Driver.get().findElements(By.xpath("//select['aa_accountId']//option")).get(4).isSelected();



        }else{
            String accountSaving=Driver.get().findElement(By.xpath("//select")).getText();;
            Assert.assertTrue(accountSaving.contains(expectedTitle));

        }


    }
}
