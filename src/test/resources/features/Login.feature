Feature: Login
Background:
    Given User on the login page
    When User clicks the sign-in button
  @login
  Scenario: User log in with valid credentials
    And User enters "username" and "password"
    Then User should be able to login

  Scenario: User log in with invalid credentials
    And  User enters "user" and "password"
    Then User should Not be able to login

