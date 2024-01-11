Feature: Forget Password functionality

  @ForgotPassword
  Scenario: Reset password on forgetting it
    Given User opens the Application
    When User clicks on MyAccount
    And Selects login option
    And Click on Forgotten Password option
    And Enters valid email address "slimtest1@gmail.com"
    And User clicks on Continue
    Then Proper confirmation message should be displayed
