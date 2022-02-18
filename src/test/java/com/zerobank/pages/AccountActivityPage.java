package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{
    @FindBy(xpath = "//li[@id='account_activity_tab']//a")
    public WebElement accountActivity;

    @FindBy(xpath = "//div[@id='all_transactions_for_account']//th")
    public List<WebElement> accountActivityTable;

    @FindBy(xpath = "//select[@id='aa_accountId']")
    public WebElement accountActivityDropdown;
    @FindBy(xpath = "//a[text()='Find Transactions']")
    public WebElement findTransactionTab;

    @FindBy(xpath = "//input[@id='aa_fromDate']")
    public WebElement fromDate;

    @FindBy(xpath = "//input[@id='aa_toDate']")
    public WebElement toDate;

    @FindBy(xpath = "//button[text()='Find']")
    public WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//table//tbody//tr//td[1]")
    public List<WebElement> allDates;

    @FindBy(xpath = "//input[@id='aa_description']")
    public WebElement description;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[2]")
    public List<WebElement> descriptionResult;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[3]")
    public List<WebElement> depositElement;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tbody//tr//td[4]")
    public List<WebElement> withdrowalElement;

    @FindBy(xpath = "//select[@id='aa_type']")
    public WebElement typeElement;
}
