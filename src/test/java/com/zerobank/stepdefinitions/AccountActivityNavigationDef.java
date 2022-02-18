package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class AccountActivityNavigationDef {
    @When("the user clicks on	Savings	link on the	Account	Summary	page")
    public void the_user_clicks_on_Savings_link_on_the_Account_Summary_page() {
        new AccountSummaryPage().savingElement.click();
    }

    @When("the user clicks on	Brokerage link on the Account Summary page")
    public void theUserClicksOnBrokerageLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().brokerageElement.click();
    }

    @When("the user clicks on	Checking link on the Account Summary page")
    public void theUserClicksOnCheckingLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().CheckingElement.click();
    }

    @When("the user clicks on	Credit card link on	the	Account	Summary	page")
    public void theUserClicksOnCreditCardLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().CreditCardElement.click();
    }

    @When("the user clicks on	Loan link on the Account Summary page")
    public void theUserClicksOnLoanLinkOnTheAccountSummaryPage() {
        new AccountSummaryPage().LoanElement.click();
    }
}
