package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AccountActivity {

    public AccountActivity(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//*[@id=\"account_activity_link\"]")
    public WebElement accountActivityLink;

    @FindBy(xpath="//a[@href='/bank/account-activity.html?accountId=1']")
    public WebElement savingLink;

   @FindBy(xpath="//a[@href='/bank/account-activity.html?accountId=6']")
    public WebElement brokerageLink;

   @FindBy(xpath="//a[@href='/bank/account-activity.html?accountId=2']")
    public WebElement checkingLink;

    @FindBy(xpath="//a[@href='/bank/account-activity.html?accountId=2']")
    public WebElement creditCardLink;

    @FindBy(xpath="//a[@href='/bank/account-activity.html?accountId=2']")
    public WebElement loanLink;

    @FindBy(xpath="//*[@id=\"tabs\"]/ul/li[2]/a")
    public WebElement findTransactionLink;





}
