package com.zerobank.stepdefinitions;

import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class LoginStepDef {
    LoginPage loginPage=new LoginPage();

    @Given("User on the login page")
    public void user_on_the_login_page() {
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("User clicks the sign-in button")
    public void user_clicks_the_sign_in_button() {
        loginPage.signInButton.click();
    }
    @When("User enters {string} and {string}")
    public void user_enters_and(String username, String password) {
        loginPage.login(username,password);
    }
    @Then("User should be able to login")
    public void user_should_be_able_to_login() {
        BrowserUtils.waitFor(5);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals("Zero - Account Summary", actualTitle);
    }
    @Then("User should Not be able to login")
    public void user_should_Not_be_able_to_login() {
        Driver.get().navigate().back();
        BrowserUtils.waitFor(2);
        String actualTitle=loginPage.errorText.getText();
        Assert.assertEquals("Login and/or password are wrong.",actualTitle);
    }

}
