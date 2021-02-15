package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.AccountSummary;
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
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        loginPage.errorPageBackSafety.click();
    }



    @Then("the {string} page should be displayed")
    public void the_page_should_be_displayed(String expectedTitle) {


        Assert.assertEquals(expectedTitle,Driver.get().getTitle());
    }



    @Then("error message Login and|or password are wrong should be displayed")
    public void error_message_Login_and_or_password_are_wrong_should_be_displayed() {
        LoginPage loginPage=new LoginPage();

        Assert.assertEquals(loginPage.expected,loginPage.errorMessage.getText());

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