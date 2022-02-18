package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;

public class AccountSummaryDef {
    @Given("the user logged in")
    public void the_user_logged_in() {
        LoginPage loginPage=new LoginPage();
        Driver.get().get(ConfigurationReader.get("url"));
        loginPage.signInButton.click();
        loginPage.login("username","password");
    }

    @When("Account Summary page title is {string}")
    public void account_Summary_page_title_is(String title) {
        BrowserUtils.waitFor(5);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(title, actualTitle);
    }

    @Then("The account types are")
    public void the_account_types_are(List<String> expectedaccountTypes) {
        List<String> actualaccountTypes= BrowserUtils.getElementsText(new AccountSummaryPage().accountsInfo);
        Assert.assertEquals(expectedaccountTypes,actualaccountTypes);
    }

    @Then("Credit Accounts table columns are")
    public void credit_Accounts_table_columns_are(List<String> expectedAccountColumns) {
        List<String> actualAccountColumns=BrowserUtils.getElementsText(new AccountSummaryPage().accountSummaryTableColumns);
        Assert.assertEquals(expectedAccountColumns,actualAccountColumns);
    }
}
