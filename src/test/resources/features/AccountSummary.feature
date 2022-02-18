Feature: Account Summary page

  Background:
    Given the user logged in
    Then  Account Summary page title is "Zero - Account Summary"

  Scenario: Account types
    Then  The account types are
      | Cash Accounts       |
      | Investment Accounts |
      | Credit Accounts     |
      | Loan Accounts       |

  Scenario: Credit Accounts table
    Then Credit Accounts table columns are
      | Account     |
      | Credit Card |
      | Balance     |

