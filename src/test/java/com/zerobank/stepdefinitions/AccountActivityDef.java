package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class AccountActivityDef {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("user click Account Activity title")
    public void user_click_Account_Activity_title() {
        BrowserUtils.waitFor(2);
        accountActivityPage.accountActivity.click();
    }

    @Then("user should be see {string}")
    public void user_should_be_see(String title) {
        BrowserUtils.waitFor(1);
        String actualTitle = Driver.get().getTitle();
        Assert.assertEquals(actualTitle, title);
    }

    @Then("user should be see default option {string}")
    public void user_should_be_see_default_option(String expectedDefaultOption) {
        Select select = new Select(accountActivityPage.accountActivityDropdown);
        String actualDefaultOption = select.getFirstSelectedOption().getText();
        Assert.assertEquals(actualDefaultOption, expectedDefaultOption);
    }

    @When("Account Dropdown options are")
    public void account_Dropdown_options_are(List<String> expectedDropdownOptions) {
        Select select = new Select(accountActivityPage.accountActivityDropdown);
        List<String> allDropdownOptions = BrowserUtils.getElementsText(select.getOptions());
        Assert.assertEquals("Verify that Dropdown options are not equal", allDropdownOptions, expectedDropdownOptions);
    }

    @Then("Transactions table column names are")
    public void transactions_table_column_names_are(List<String> expectedaccountActivityTable) {
        BrowserUtils.waitFor(2);
        List<String> actualaccountActivityTable = BrowserUtils.getElementsText(accountActivityPage.accountActivityTable);
        Assert.assertEquals(expectedaccountActivityTable, actualaccountActivityTable);
    }


}
