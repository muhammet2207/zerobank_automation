
Feature: Purchase Foreign Currency
Background:
  When the user logged in
  When user goes to Pay Bills tab
  Given the user accesses the Purchase foreign currency cash tab

  Scenario: Available currencies
    Then following currencies should be available
      | Australia (dollar)    |
      | Canada (dollar)       |
      | Switzerland (franc)   |
      | China (yuan)          |
      | Denmark (krone)       |
      | Eurozone (euro)       |
      | Great Britain (pound) |
      | Hong Kong (dollar) |
      | Japan (yen)           |
      | Mexico (peso)         |
      | Norway (krone)        |
      | New Zealand (dollar)  |
      | Sweden (krona) |
      | Singapore (dollar)    |
      | Thailand (baht) |
  @wip
  Scenario: Error message for not selecting currency
    When user tries to calculate cost without selecting a currency
    Then error message should be displayed

  Scenario: Error message for not entering value
    When user tries to calculate cost without entering a value
    Then error message should be displayed