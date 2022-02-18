
Feature:    Navigating	to	specific	accounts	in	Accounts	Activity
Background:
  Given the user logged in

  Scenario: Savings	account	redirect
    When the user clicks on	Savings	link on the	Account	Summary	page
    Then user should be see "Zero - Account Activity"
    Then user should be see default option "Savings"

  Scenario:	Brokerage	account	redirect
    When the user clicks on	Brokerage link on the Account Summary page
    Then user should be see "Zero - Account Activity"
    Then user should be see default option "Brokerage"

  Scenario:	Checking	account	redirect
    When the user clicks on	Checking link on the Account Summary page
    Then user should be see "Zero - Account Activity"
    Then user should be see default option "Checking"

  Scenario:	Credit	Card	account	redirect
    When the user clicks on	Credit card link on	the	Account	Summary	page
    Then user should be see "Zero - Account Activity"
    Then user should be see default option "Credit Card"
  @nav
  Scenario:	Loan	account	redirect
    When the user clicks on	Loan link on the Account Summary page
    Then user should be see "Zero - Account Activity"
    Then user should be see default option "Loan"


