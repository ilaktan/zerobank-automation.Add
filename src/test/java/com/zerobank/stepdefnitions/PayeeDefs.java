package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountSummary;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBills;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Map;

public class PayeeDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {

        AccountSummary accountSummary=new AccountSummary();
        accountSummary.onlineBankingLink.click();

        PayBills payBills=new PayBills();
        payBills.pay_bills_link.click();
        payBills.addNewPayeeLink.click();
        BrowserUtils.waitFor(2);

    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String>option) {
        Driver.get().findElement(By.xpath("//*[@id=\"np_new_payee_name\"]")).sendKeys(option.get("Payee Name"));
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@id=\"np_new_payee_address\"]")).sendKeys(option.get("Payee Address"));
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@id=\"np_new_payee_account\"]")).sendKeys(option.get("Account"));
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@id=\"np_new_payee_details\"]")).sendKeys(option.get("Payee details"));
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[@id=\"add_new_payee\"]")).click();
        BrowserUtils.waitFor(2);

        String expected="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Assert.assertEquals(expected,Driver.get().findElement(By.id("alert_content")).getText());





    }

    @Then("message The new payee The Law Offices of Hyde, Price & Scharks was successfully created.should be displayed")
    public void message_The_new_payee_The_Law_Offices_of_Hyde_Price_Scharks_was_successfully_created_should_be_displayed() {
        String expected="The new payee The Law Offices of Hyde, Price & Scharks was successfully created.";
        Driver.get().findElement(By.xpath("//*[@id=\"alert_content\"]")).getText();
        Assert.assertEquals(expected,Driver.get().findElement(By.xpath("//*[@id=\"alert_content\"]")).getText());
    }
    @When("the user navigate Online Banking, Pay Bill")
    public void the_user_navigate_Online_Banking_Pay_Bill() {
        AccountSummary accountSummary=new AccountSummary();
        accountSummary.onlineBankingLink.click();
        PayBills payBills=new PayBills();
        payBills.pay_bills_link.click();
    }

    @When("the user completes the pay operation")
    public void the_user_completes_the_pay_operation() {

        PayBills payBills=new PayBills();

        payBills.amountLink.sendKeys("1000");

        payBills.dateInbox.sendKeys("2021-02-18");
        payBills.payClickLink.click();

    }

    @Then("the user should see {string} message")
    public void the_user_should_see_message(String expected) {
        PayBills payBills=new PayBills();

        Assert.assertEquals(expected,payBills.successfullySubmitted.getText());

    }

    @When("user tries to make a payment without entering the amount or date")
    public void user_tries_to_make_a_payment_without_entering_the_amount_or_date() {
        PayBills payBills=new PayBills();
        payBills.payClickLink.click();

    }
    @Then("the user should be able to see {string} message")
    public void the_user_should_be_able_to_see_message(String expected) {
        PayBills payBills=new PayBills();
        String message = payBills.amountLink.getAttribute("validationMessage");
        //System.out.println("message = " + message);
        Assert.assertEquals(expected,message);



    }

}
