package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(xpath="//button[@id='signin_button']")
    public WebElement signInButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='user_password']")
    public WebElement password;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement submit;

    @FindBy(css = ".alert.alert-error")
    public WebElement errorText;

    public void login(String userNameStr, String passwordStr) {
        BrowserUtils.waitForPageToLoad(5);
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
        submit.click();
        Driver.get().navigate().to("http://zero.webappsecurity.com/bank/account-summary.html");
                BrowserUtils.waitFor(3);

    }


}
