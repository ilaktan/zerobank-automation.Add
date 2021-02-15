package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountSummary {
    public AccountSummary(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//*[@id='onlineBankingMenu']/div/strong")
    public WebElement onlineBankingLink;

    @FindBy(xpath="//*[@id='account_summary_link']")
    public WebElement accountSummaryLink;

    @FindBy(xpath="(//h2[@class=\"board-header\"])[1]")
    public WebElement cashAccounts;

    @FindBy(xpath="(//h2[@class=\"board-header\"])[2]")
    public WebElement investmentAccount;

    @FindBy(xpath="(//h2[@class=\"board-header\"])[3]")
    public WebElement credittAccount;

    @FindBy(xpath="(//h2[@class=\"board-header\"])[4]")
    public WebElement loanAccount;

    @FindBy(xpath = "//h2[@class=\"board-header\"]")
    public List<WebElement> menuOptions;

    @FindBy(xpath="(//table[@class='table'])[3]/thead/tr/th")
    public List <WebElement> CreditAccountTable;


}
