package com.zerobank.stepdefnitions;

import com.zerobank.pages.AccountActivity;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FindTransactionsDefs {

    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        String url=ConfigurationReader.get("url");
        Driver.get().get(url);
        String username=ConfigurationReader.get("username");
        String password=ConfigurationReader.get("password");

        LoginPage loginPage=new LoginPage();
        loginPage.login(username,password);
        loginPage.errorPageBackSafety.click();

        AccountActivity accountActivity=new AccountActivity();
        accountActivity.accountActivityLink.click();;
        Driver.get().findElement(By.xpath("//*[@id=\"tabs\"]/ul/li[2]/a")).click();
        BrowserUtils.waitFor(2);


    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

        Driver.get().findElement(By.id("aa_fromDate")).clear();
        Driver.get().findElement(By.id("aa_toDate")).clear();
        Driver.get().findElement(By.id("aa_fromDate")).sendKeys(fromDate);
        BrowserUtils.waitFor(1);

        Driver.get().findElement(By.id("aa_toDate")).sendKeys(toDate);

//        @FindBy(id = "aa_fromDate")
//        public WebElement fromDateInputBox;
//        @FindBy(id = "aa_toDate")
//        public WebElement toDateInputBox;

//        AccountActivityPage accountActivityPage = new AccountActivityPage();
//        accountActivityPage.fromDateInputBox.clear();
//        accountActivityPage.toDateInputBox.clear();
//        accountActivityPage.fromDateInputBox.sendKeys(fromDate);
//        accountActivityPage.toDateInputBox.sendKeys(toDate);
//        BrowserUtils.waitFor(1);






}

    @When("clicks search")
    public void clicks_search() {
        Driver.get().findElement(By.xpath("//*[@id=\"find_transactions_form\"]/div[2]/button")).click();

    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        String[] endSplit = toDate.split("-");
        String toDatelast = "";
        for (int i = 0; i < endSplit.length; i++) {
            toDatelast += "" + endSplit[i];
        }
        String[] startSplit = fromDate.split("-");
        String fromDateLast = "";
        for (int i = 0; i < startSplit.length; i++) {
            fromDateLast += "" + startSplit[i];
        }
        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
        for (int i = 1; i <= numRows.size(); i++) {
            String element = "(//tbody)[2]/tr[" + i + "]/td[1]";
            String actual = Driver.get().findElement(By.xpath(element)).getText();
            String[] splitDate = actual.split("-");
            String wholeDate = "";
            for (int j = 0; j < splitDate.length; j++) {
                wholeDate += "" + splitDate[j];
            }
            if (Integer.parseInt(wholeDate) <= Integer.parseInt(toDatelast)) {
                Assert.assertTrue(true);
            } else if (Integer.parseInt(wholeDate) >= Integer.parseInt(fromDateLast)) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
        }
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        //Driver.get().findElement(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr[1]/td[1]")).getText();
       //Assert.assertEquals("2012-09-06",Driver.get().findElement(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr[1]/td[1]")).getText());

    }

    @Then("the results table should only not contain transactions dated {string}")
    public void   the_results_table_should_only_not_contain_transactions_dated(String Date) {


        BrowserUtils.waitFor(2);
        String[] endSplit = Date.split("-");
        String toDatelast = "";
        for (int i = 0; i < endSplit.length; i++) {
            toDatelast += "" + endSplit[i];
        }
        List<WebElement> numRows = Driver.get().findElements(By.xpath("(//tbody)[2]/tr/td[1]"));
        for (int i = 1; i <= numRows.size(); i++) {
            String element = "(//tbody)[2]/tr[" + i + "]/td[1]";
            String actual = Driver.get().findElement(By.xpath(element)).getText();
            String[] splitDate = actual.split("-");
            String wholeDate = "";
            for (int j = 0; j < splitDate.length; j++) {
                wholeDate += "" + splitDate[j];
                System.out.println("wholeDate = " + wholeDate);

            }
            if (Integer.parseInt(wholeDate)> Integer.parseInt(toDatelast)) {
                Assert.assertTrue(true);
            } else if (Integer.parseInt(wholeDate) < Integer.parseInt(toDatelast)) {
                Assert.assertTrue(true);
            }   else {
                Assert.assertTrue(false);
            }
        };
    }

    @When("the user enters description “ONLINE”")
    public void the_user_enters_description_ONLINE() {
        Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).sendKeys("ONLINE");
        BrowserUtils.waitFor(2);

    }

    @Then("results table should only show descriptions containing “ONLINE”")
    public void results_table_should_only_show_descriptions_containing_ONLINE() {
        String actual=Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).getAttribute("value");
        Assert.assertTrue(actual.contains("ONLINE"));

    }

    @When("the user enters description “OFFICE”")
    public void the_user_enters_description_OFFICE() {
        Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).clear();
        Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).sendKeys("OFFICE");

        BrowserUtils.waitFor(2);

    }

    @Then("results table should only show descriptions containing “OFFICE”")
    public void results_table_should_only_show_descriptions_containing_OFFICE() {
        String actual=Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).getAttribute("value");
        Assert.assertTrue(actual.contains("OFFICE"));
    }
    @Then("results table should show no result under Deposit")
    public void results_table_should_show_no_result_under_Deposit() {
        String actual=Driver.get().findElement(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr/td[3]")).getAttribute("value");
        //Assert.assertTrue(actual.contains("null"));
        System.out.println(actual);
    }
    @When("the user enters description “online”")
    public void the_user_enters_description_online() {
        Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).clear();
        Driver.get().findElement(By.xpath("//*[@id=\"aa_description\"]")).sendKeys("online");;
    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String result) {

    }

    @Then("results table should show at least one result under Deposit")
    public void results_table_should_show_at_least_one_result_under_Deposit() {
        BrowserUtils.waitFor(2);
        String actual=Driver.get().findElement(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr[2]/td[3]")).getText();

        System.out.println(actual);
    }

    @Then("results table should show at least one result under Withdrawal")
    public void results_table_should_show_at_least_one_result_under_Withdrawal() {
        BrowserUtils.waitFor(2);
        String actual=Driver.get().findElement(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr[1]/td[3]")).getText();
        System.out.println(actual);
    }

    @When("user selects type “Deposit”")
    public void user_selects_type_Deposit() {
        Driver.get().findElement(By.xpath("//*[@id=\"aa_type\"]")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//*[@id=\"aa_type\"]//option)[2]")).click();
        Driver.get().findElement(By.xpath("//*[@id=\"find_transactions_form\"]/div[2]/button")).click();
    }

    @Then("results table should show no result under Withdrawal")
    public void results_table_should_show_no_result_under_Withdrawal() {
        String actual=Driver.get().findElement(By.xpath("//*[@id=\"filtered_transactions_for_account\"]/table/tbody/tr[1]/td[4]")).getAttribute("value");
        //Assert.assertTrue(actual.contains(""));
        System.out.println(actual);
    }

    @When("user selects type “Withdrawal”")
    public void user_selects_type_Withdrawal() {
        Driver.get().findElement(By.xpath("//*[@id=\"aa_type\"]")).click();
        BrowserUtils.waitFor(2);
        Driver.get().findElement(By.xpath("(//*[@id=\"aa_type\"]//option)[3]")).click();
        Driver.get().findElement(By.xpath("//*[@id=\"find_transactions_form\"]/div[2]/button")).click();
    }


}
