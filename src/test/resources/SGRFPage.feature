Feature: The page allows the user to enter their details and register if filled in correctly
  Scenario: The user enters different levels of information and gets the correct results
    Given I am on the SGRFPage
    When I enter all details correctly
    Then my application is registered

    Given I am on the SGRFPage
    When I enter all details incorrectly
    Then I am unable to register

    Given I am on the SGRFPage
    When I enter minimum required information
    Then I am able to register