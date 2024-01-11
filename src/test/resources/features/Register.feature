Feature: Registration functionality

  @register
  Scenario: User creates an account only with mandatory fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | slim       |
      | lastName  | SMTest     |
      | telephone | 1234567890 |
      | password  |      12345 |
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  @register
  Scenario: User creates an account with all fields
    Given User navigates to Register Account page
    When User enters the details into below fields
      | firstName | slim       |
      | lastName  | SMTest     |
      | telephone | 1234567890 |
      | password  |      12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User account should get created successfully

  @register
  Scenario: User creates a duplicate account
    Given User navigates to Register Account page
    When User enters the details into below fields with duplicate email
      | firstName | slim                |
      | lastName  | SMTest              |
      | email     | slimtest9@gmail.com |
      | telephone |         01234560987 |
      | password  |               12345 |
    And User selects Yes for Newsletter
    And User selects Privacy Policy
    And User clicks on Continue button
    Then User should get a proper warning about duplicate email

  @register
  Scenario: User creates an account without filling any details
    Given User navigates to Register Account page
    When User dont enter any details into fields
    And User clicks on Continue button
    Then User should get proper warning messages for every mandatory field
