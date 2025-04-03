Feature: feature to test the create account with valid input

  Scenario: Check account creation with valid input
    Given user is on the account creation page
    When user fills out valid input into all the fields
    Then clicks on create account
