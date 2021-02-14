package com.zerobank.stepdefnitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class LoginStepDefs {

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.id("signin_button")).click();
        String username ="username";
        String password ="password";
        new LoginPage().login(username,password);
        Driver.get().findElement(By.id("primary-button")).click();
    }

    @When("the user clicks on Savings link on the Account Summary page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() throws InterruptedException {
        Driver.get().findElement(By.xpath("//*[strong='Online Banking']//strong")).click();

        Driver.get().findElement(By.id("account_summary_link")).click();


    }

    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedTitle) {
        System.out.println("expectedTitle = " + expectedTitle);
        BrowserUtils.waitFor(2);
        String accountSummary=Driver.get().findElement(By.xpath("//a[@href='/bank/redirect.html?url=account-activity.html']")).getText();
        Assert.assertTrue(accountSummary.contains(expectedTitle));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedTitle) {

        if(expectedTitle.equals("Savings")){


            String accountSaving=Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=1']")).getText();;
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

    @When("the user clicks on Brokerage link on the Account Summary page")
    public void the_user_clicks_on_Brokerage_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[strong='Online Banking']//strong")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("account_summary_link")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=6']")).click();

    }
    @When("the user clicks on Checking link on the Account Summary page")
    public void the_user_clicks_on_Checking_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[strong='Online Banking']//strong")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("account_summary_link")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=6']")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[2]")).click();
        Driver.get().findElement(By.xpath("//select['aa_accountId']")).click();

        Driver.get().findElement(By.xpath("(//select['aa_accountId']//option)[2]")).click();
        BrowserUtils.waitFor(3);



    }
    @When("the user clicks on Credit card link on the Account Summary page")
    public void the_user_clicks_on_Credit_card_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[strong='Online Banking']//strong")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("account_summary_link")).click();
        Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=5']")).click();

    }
    @When("the user clicks on Loan link on the Account Summary page")
    public void the_user_clicks_on_Loan_link_on_the_Account_Summary_page() {
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[strong='Online Banking']//strong")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("account_summary_link")).click();
        Driver.get().findElement(By.xpath("//a[@href='/bank/account-activity.html?accountId=4']")).click();

    }



    @Given("users with wrong username or wrong password should not be able to login")
    public void users_with_wrong_username_or_wrong_password_should_not_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("users with blank username or password should also not be able to login")
    public void users_with_blank_username_or_password_should_also_not_be_able_to_login() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user tries to login with invalid information")
    public void user_tries_to_login_with_invalid_information() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Then("error message Login and|or password are wrong should be displayed")
    public void error_message_Login_and_or_password_are_wrong_should_be_displayed() {
        LoginPage loginPage=new LoginPage();

        Assert.assertEquals(loginPage.expected,loginPage.errorMessage.getText());

    }







    @Then("Account summary page should be displayed")
    public void account_summary_page_should_be_displayed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
    }

    @When("user tries to login with invalid {string} or {string}")
    public void user_tries_to_login_with_invalid_or(String username, String password) {
        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);


    }

    @When("the user enters valid user name and password")
    public void the_user_enters_valid_user_name_and_password() {
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        loginPage.errorPageBackSafety.click();

    }

    @Then("user should be able to login")
    public void user_should_be_able_to_login() {
       String actualTitle=Driver.get().getTitle();
        String expected="Zero - Personal Banking - Loans - Credit Cards";
        Assert.assertEquals(expected,actualTitle);



    }
}


