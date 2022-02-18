package com.zerobank.stepdefinitions;
import com.zerobank.pages.DashboardPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class PayBillsDef {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("user goes to Pay Bills tab")
    public void user_goes_to_Pay_Bills_tab() {
        BrowserUtils.waitFor(1);
        payBillsPage.PayBills.click();
    }

    @When("the user choose Payee type")
    public void the_user_choose_Payee_type() {
        Select select = new Select(payBillsPage.payeDropdown);
        select.selectByValue("bofa");
    }

    @When("the user choose Account type")
    public void the_user_choose_Account_type() {
        Select select = new Select(payBillsPage.accountDropdown);
        select.selectByVisibleText("Credit Card");
    }

    @When("the user  fill out the amount as {string}")
    public void the_user_fill_out_the_amount_as(String amount) {
        payBillsPage.amountBox.sendKeys(amount);
        BrowserUtils.waitFor(1);
        String result = null;
        for (int i = 0; i < amount.length(); i++) {
            if (!Character.isDigit(amount.charAt(i))) {
                result = "Only digit is acceptable";
            }
        }
        System.out.println(result);
    }

    @When("the user  fills the date {string}")
    public void the_user_fills_the_date(String date) {
        BrowserUtils.waitFor(2);
        JavascriptExecutor jse = (JavascriptExecutor) Driver.get();
        jse.executeScript("arguments[0].setAttribute('value','" + date + "')", payBillsPage.dateBox);
    }

    @When("the user writes the description as {string}")
    public void the_user_writes_the_description_as(String string) {
        payBillsPage.descriptionBox.sendKeys(string);
    }

    @When("the user clicks Pay button")
    public void the_user_clicks_Pay_button() {
        payBillsPage.payButton.click();

    }

    @Then("the user see {string}")
    public void the_user_see(String expectedPaymentResult) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        String actualPaymentResult = payBillsPage.paymentResult.getText();
        Assert.assertEquals("Verify the payment result", actualPaymentResult, expectedPaymentResult);
    }

    @Then("the user see the {string}")
    public void theUserSeeThe(String expectedPupUp) throws InterruptedException {
        Thread.sleep(4000);
        String actualPupUp = new PayBillsPage().amountBox.getAttribute("validationMessage");
        Assert.assertEquals("Verify the pup-up", actualPupUp, expectedPupUp);
    }

    @Then("the user cannot see {string}")
    public void theUserCannotSee(String expectedPaymentResult) {
        new DashboardPage().waitUntilLoaderScreenDisappear();
        String actualPaymentResult = payBillsPage.paymentResult.getText();
        Assert.assertEquals("Verify the payment result", actualPaymentResult, expectedPaymentResult);
    }

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        payBillsPage.addNewPayeTab.click();
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> info) {
        Actions actions = new Actions(Driver.get());
        actions.click(payBillsPage.payeeNameInbox)
                .sendKeys(info.get("Payee Name"), Keys.TAB)
                .sendKeys(info.get("Payee Address"), Keys.TAB)
                .sendKeys(info.get("Account"), Keys.TAB)
                .sendKeys(info.get("Payee details"))
                .sendKeys(Keys.ENTER).build().perform();
//            payBillsPage.payeeNameInbox.sendKeys(info.get("Payee Name"),Keys.TAB);
//            payBillsPage.payeeAddressInbox.sendKeys("100 Same st, Anytown, USA, 10001");
//            payBillsPage.AccountInbox.sendKeys("Checking");
//            payBillsPage.payeeDetailsInbox.sendKeys("XYZ account");
//            payBillsPage.addButton.click();
    }

    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String message) {
        String text = payBillsPage.alertMessage.getText();
        Assert.assertEquals(text, message);
    }

    @Given("the user accesses the Purchase foreign currency cash tab")
    public void the_user_accesses_the_Purchase_foreign_currency_cash_tab() {
        payBillsPage.purchaseForeign.click();
    }

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> expectedList) {
        Select select=new Select(payBillsPage.selectCurrency);
        List<String> actualList = BrowserUtils.getElementsText(select.getOptions());
        actualList.remove(0);
        Assert.assertEquals(expectedList,actualList);
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.calculateCostButton.click();
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Alert alert=Driver.get().switchTo().alert();
        WebDriverWait wait=new WebDriverWait(Driver.get(),2);
        wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("alert.getText() = " + alert.getText());

    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        new Select(payBillsPage.selectCurrency).selectByIndex(5);
        payBillsPage.calculateCostButton.click();
    }

}
