package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.*;

public class FindTransactionsDef {
    AccountActivityPage accountActivityPage=new AccountActivityPage();
    @When("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_Find_Transactions_tab() {
        BrowserUtils.waitForPageToLoad(2);
        accountActivityPage.findTransactionTab.click();
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {
        BrowserUtils.waitFor(2);
        accountActivityPage.fromDate.clear();
        accountActivityPage.toDate.clear();
        accountActivityPage.fromDate.sendKeys(fromDate);
        accountActivityPage.toDate.sendKeys(toDate);
    }

    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.findButton.click();
        BrowserUtils.waitFor(2);
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date fromD = dateFormat.parse(fromDate);
            Date afterD = dateFormat.parse(toDate);
            BrowserUtils.waitFor(1);
            List<String> datesString = BrowserUtils.getElementsText(new AccountActivityPage().allDates);
            List<Date> actualDates = new ArrayList<>();
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
            for (Date actualDate : actualDates) {
                boolean isBetween = (actualDate.after(fromD)) || actualDate.equals(fromD) &&
                        (actualDate.before(afterD)) || actualDate.equals(afterD);
                Assert.assertTrue("Date is out of range", isBetween);
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format, needs to be yyyy-MM-dd");
        }
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
        List<Date> actualDates = new ArrayList<>();
        try {
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format, correct format should be: yyyy-MM-dd");
        }
        List<Date> sortedDate = new ArrayList<>(actualDates);

        sortedDate.sort(Collections.reverseOrder());
        for (int i = 0; i < sortedDate.size(); i++) {
            Assert.assertEquals(sortedDate.get(i), (actualDates.get(i)));
        }
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        List<String> datesString = BrowserUtils.getElementsText(accountActivityPage.allDates);
        List<Date> actualDates = new ArrayList<>();
        Date dateNotAcceptable = null;
        try {
            dateNotAcceptable = dateFormat.parse(date);
            for (String stringDate : datesString) {
                actualDates.add(dateFormat.parse(stringDate));
            }
        } catch (ParseException e) {
            Assert.fail("Wrong date format please follow this: yyyy-MM-dd");
        }
        for (Date actualDate : actualDates) {
            Assert.assertNotEquals(actualDate, dateNotAcceptable);
        }
    }
    @When("the user enters description {string}")
    public void the_user_enters_description(String searchItem) {
        accountActivityPage.description.clear();
        accountActivityPage.description.sendKeys(searchItem);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        List<String> descriptionElement = BrowserUtils.getElementsText(accountActivityPage.descriptionResult);
        for (String each : descriptionElement) {
            Assert.assertTrue(each.contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        List<String> descriptionElement = BrowserUtils.getElementsText(accountActivityPage.descriptionResult);
        for (String each : descriptionElement) {
            Assert.assertTrue(each.contains(string));
        }
    }

    @Then("results table should show at least one result under Deposit")
    public void resultsTableShouldShowAtLeastOneResultUnderDeposit() {
        List<String> depositElements=BrowserUtils.getElementsText(accountActivityPage.depositElement);
        Assert.assertFalse(depositElements.isEmpty());
    }

    @Then("results table should show at least one result under Withdrawal")
    public void resultsTableShouldShowAtLeastOneResultUnderWithdrawal() {
        List<String> withdrowalElements=BrowserUtils.getElementsText(accountActivityPage.withdrowalElement);
        Assert.assertFalse(withdrowalElements.isEmpty());
    }

    @When("user selects type “Deposit”")
    public void userSelectsTypeDeposit() {
        Select select=new Select(accountActivityPage.typeElement);
        select.selectByValue("DEPOSIT");
    }

    @But("results table should show no result under Withdrawal")
    public void resultsTableShouldShowNoResultUnderWithdrawal() {
        List<String> withdrowalElements=BrowserUtils.getElementsText(accountActivityPage.withdrowalElement);
        System.out.println("withdrowalElements = " + withdrowalElements);
        Assert.assertFalse(withdrowalElements.isEmpty());
    }

    @But("results table should show no result under Deposit")
    public void resultsTableShouldShowNoResultUnderDeposit() {
        List<String> depositElements=BrowserUtils.getElementsText(accountActivityPage.depositElement);
        System.out.println("depositElements = " + depositElements);
        Assert.assertFalse(depositElements.isEmpty());
    }

    @When("user selects type “Withdrawal”")
    public void userSelectsTypeWithdrawal() {
        Select select=new Select(accountActivityPage.typeElement);
        select.selectByValue("WITHDRAWAL");
    }
}
