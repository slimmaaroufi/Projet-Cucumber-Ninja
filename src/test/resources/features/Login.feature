Feature: Login functionality

  @login
  Scenario Outline: Login with valid credentials
    Given User navigates to login page
    When User enters valid email address <username> into email field
    And User enters valid password <password> into password field
    And User clicks on Login button
    Then User should get successfully logged in

    Examples: 
      | username            | password |
      | slimtest9@gmail.com |    12345 |
      | slimtest1@gmail.com |    12345 |
      | slimtest2@gmail.com |    12345 |

  @login
  Scenario: Login with invalid credentials
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  @login
  Scenario: Login with valid email and invalid password
    Given User navigates to login page
    When User enters valid email address "slimtest1@gmail.com" into email field in the login page
    And User enters invalid password "1234567890" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  @login
  Scenario: Login with invalid email and valid password
    Given User navigates to login page
    When User enters invalid email address into email field
    And User enters valid password "12345" into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch

  @login
  Scenario: Login without providing any credentails
    Given User navigates to login page
    When User dont enter email address into email field
    And User dont enter password into password field
    And User clicks on Login button
    Then User should get a proper warning message about credentials mismatch
