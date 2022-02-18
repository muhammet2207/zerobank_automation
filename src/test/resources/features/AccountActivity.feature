@account
Feature: Account Activity Page

  Background:
    Given the user logged in
    When user click Account Activity title

  Scenario: User should able to see title
    Then user should be see "Zero - Account Activity"

  Scenario: User should be able to drop-down
    Then user should be see default option "Savings"
    Then Account Dropdown options are
      | Savings     |
      | Checking    |
      | Loan        |
      | Credit Card |
      | Brokerage   |

  Scenario: User should be see Transaction headers title
    Then Transactions table column names are
      | Date        |
      | Description |
      | Deposit     |
      | Withdrawal  |







