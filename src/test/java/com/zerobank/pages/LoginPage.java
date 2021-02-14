package com.zerobank.pages;



import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(id="user_login")
    public WebElement userName;



    @FindBy(id="user_password")
    public WebElement password;

    @FindBy(name = "submit")
    public WebElement submit;

    @FindBy(id="primary-button")
    public WebElement errorPageBackSafety;

    @FindBy(id="signin_button")
    public WebElement signinButton;

//    @FindBy(xpath="//*[@id='login_form']/div[1]")
    @FindBy(xpath="//*[@id='login_form']/div[1]")
    public WebElement errorMessage;

    public String expected="Login and/or password are wrong.";

////*[@id="login_form"]/div[1]


    public void login(String userNameStr, String passwordStr) {
        signinButton.click();
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        // verification that we logged
    }
    //BREAK UNTIL 12:10

}