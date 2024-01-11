@order
Feature: Order functionality

  @order1
  Scenario Outline: Order with valid scenario
    Given User opens the Application
    When User enters valid product "HP" into Search box field
    And User clicks on Search button
    And User should get valid product displayed in search results
    And I add any product to bag and checkout
    And Verify the title "HP LP3065"
    And User clicks on Add to cart button
    Then I should see that the order is placed and get a successfully message
