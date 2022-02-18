Feature:Pay Bills Page
  Background:
    Given the user logged in
    When user goes to Pay Bills tab

  Scenario: User should be able to go Pay Bills tab
    Then user should be see "Zero - Pay Bills"

  Scenario: User should be able to do successful payment
    When the user choose Payee type
    And the user choose Account type
    And the user  fill out the amount as "350"
    And the user  fills the date "2022-02-16"
    And the user writes the description as "A successful payment"
    And the user clicks Pay button
    Then the user see "The payment was successfully submitted."

  Scenario: User should fill the payment without entering the amount or date
    When the user choose Payee type
    And the user choose Account type
    And the user writes the description as "Unsuccessful payment"
    And the user clicks Pay button
    Then the user see the "Please fill out this field."

  @PayBills
  Scenario: User should not able to fill the amount with alphabetical and special characters
    When the user choose Payee type
    And the user choose Account type
    And the user  fill out the amount as "Ab*^#"
    And the user  fills the date "ABC"
    And the user writes the description as "Unsuccessful payment"
    And the user clicks Pay button
    Then the user cannot see "The payment was successfully submitted."
