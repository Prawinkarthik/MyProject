Feature: Amazon Application

@smoke
  Scenario: Home page
    Given user Launch the Application Url
    When user Select The value from DropDown
    And user Select The product In Search Field
    Then user Click The Search button
    
