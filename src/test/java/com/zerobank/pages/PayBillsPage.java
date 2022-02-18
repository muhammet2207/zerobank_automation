package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.nio.file.WatchEvent;

public class PayBillsPage extends BasePage {
    @FindBy(xpath = "//a[text()='Pay Bills']")
    public WebElement PayBills;

    @FindBy(xpath = "//select[@id='sp_payee']")
    public WebElement payeDropdown;

    @FindBy(xpath = "//select[@id='sp_account']")
    public WebElement accountDropdown;

    @FindBy(xpath = "//input[@id='sp_amount']")
    public WebElement amountBox;

    @FindBy(xpath = "//input[@id='sp_date']")
    public WebElement dateBox;



    @FindBy(xpath = "//input[@id='sp_description']")
    public WebElement descriptionBox;

    @FindBy(xpath = "//input[@id='pay_saved_payees']")
    public WebElement payButton;

    @FindBy(xpath = "//div[@id='alert_content']//span")
    public WebElement paymentResult;

    @FindBy(xpath = "//a[text()='Add New Payee']")
    public WebElement addNewPayeTab;

    @FindBy(xpath = "//input[@id='np_new_payee_name']")
    public WebElement payeeNameInbox;

    @FindBy(xpath = "//textarea[@id='np_new_payee_address']")
    public WebElement payeeAddressInbox;

    @FindBy(xpath = "//input[@id='np_new_payee_account']")
    public WebElement AccountInbox;

    @FindBy(xpath = "//input[@id='np_new_payee_details']")
    public WebElement payeeDetailsInbox;

    @FindBy(xpath = "//input[@value='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//div[@id='alert_content']")
    public WebElement alertMessage;

    @FindBy(xpath = "//a[text()='Purchase Foreign Currency']")
    public WebElement purchaseForeign;

    @FindBy(xpath = "//select[@id='pc_currency']")
    public WebElement selectCurrency;

    @FindBy(id = "pc_calculate_costs")
    public WebElement calculateCostButton;
}
