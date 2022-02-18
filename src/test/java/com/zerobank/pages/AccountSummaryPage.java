package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


import java.util.List;

public class AccountSummaryPage extends BasePage {
    @FindBy(xpath = "//div/h2")
    public List<WebElement> accountsInfo;

    @FindBy(xpath = "(//table[@class='table'])[3]//th")
    public List<WebElement> accountSummaryTableColumns;

    @FindBy(linkText = "Savings")
    public WebElement savingElement;

    @FindBy(linkText = "Brokerage")
    public WebElement brokerageElement;

    @FindBy(linkText = "Checking")
    public WebElement CheckingElement;

    @FindBy(linkText = "Credit Card")
    public WebElement CreditCardElement;

    @FindBy(xpath = "//a[text()='Loan']")
    public WebElement LoanElement;
}
