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

import java.util.Map;

public class PayeeDefs {

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().findElement(By.id("signin_button")).click();
        String username ="username";
        String password ="password";
        new LoginPage().login(username,password);
        Driver.get().findElement(By.id("primary-button")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//*[strong='Online Banking']//strong")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.id("pay_bills_link")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("//a[@href='#ui-tabs-2']")).click();
        BrowserUtils.waitFor(3);

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


}
