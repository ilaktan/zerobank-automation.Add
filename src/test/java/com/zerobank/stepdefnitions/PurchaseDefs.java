package com.zerobank.stepdefnitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import java.util.List;

public class PurchaseDefs {

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
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
        Driver.get().findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[3]/a")).click();
        BrowserUtils.waitFor(3);
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> menuOptions) {


        List<String> actualOptions = BrowserUtils.getElementsText(Driver.get().findElements(By.xpath("(//*[@id=\"pc_currency\"])//option")));

       Assert.assertEquals(menuOptions.get(0),actualOptions.get(1));
        Assert.assertEquals(menuOptions.get(1),actualOptions.get(2));
        Assert.assertEquals(menuOptions.get(2),actualOptions.get(3));
        Assert.assertEquals(menuOptions.get(3),actualOptions.get(4));
        Assert.assertEquals(menuOptions.get(4),actualOptions.get(5));
        Assert.assertEquals(menuOptions.get(5),actualOptions.get(6));
        Assert.assertEquals(menuOptions.get(6),actualOptions.get(7));
        Assert.assertEquals(menuOptions.get(7),actualOptions.get(9));
        Assert.assertEquals(menuOptions.get(8),actualOptions.get(10));
        Assert.assertEquals(menuOptions.get(9),actualOptions.get(11));
        Assert.assertEquals(menuOptions.get(10),actualOptions.get(12));
        Assert.assertEquals(menuOptions.get(11),actualOptions.get(14));
        //Assert.assertTrue(actualOptions.contains(menuOptions));

        System.out.println("menuOptions = " + menuOptions);
        System.out.println("actualOptions = " + actualOptions);
    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        Driver.get().findElement(By.xpath("//*[@id=\"pc_calculate_costs\"]")).click();

    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert=Driver.get().switchTo().alert();
        System.out.println("alert.getText() = " + alert.getText());
        String expected="Please, ensure that you have filled all the required fields with valid values.";
        Assert.assertEquals(expected,alert.getText());
    }
    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        Driver.get().findElement(By.xpath("//*[@id=\"pc_calculate_costs\"]")).click();
    }

}
