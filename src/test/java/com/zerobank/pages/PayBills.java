package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class PayBills {
    public PayBills(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="pay_bills_link")
    public WebElement pay_bills_link;

    @FindBy(xpath="//a[@href='#ui-tabs-2']")
    public WebElement addNewPayeeLink;

    @FindBy(xpath="//*[@id=\"sp_payee\"]")
    public WebElement payeeLink;

    @FindBy(xpath="//select[@id=\"sp_payee\"]//option")
    public List<WebElement> payeesLink;

    @FindBy(id="sp_amount")
    public WebElement amountLink;

    @FindBy(id="(//label[@class='control-label'])[4]")
    public WebElement dateLink;

    @FindBy(id="pay_saved_payees")
    public WebElement payClickLink;

    @FindBy(id="alert_content")
    public WebElement successfullySubmitted;

    @FindBy(id="sp_date")
    public WebElement dateInbox;



}
