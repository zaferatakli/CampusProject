Feature: Login Functionality

  Scenario: Login with valid username and password
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Login with invalid username and password
    Given Navigate to Campus
    When The user types invalid username and password
    And The user clicks on the login button
    Then The user verifies warning message

  Scenario: Login with invalid username and valid password
    Given Navigate to Campus
    When The user types invalid username and valid password
    And The user clicks on the login button
    Then The user verifies warning message

  Scenario: Login with valid username and invalid password
    Given Navigate to Campus
    When The user types valid username and invalid password
    And The user clicks on the login button
    Then The user verifies warning message

  Scenario: Login with empty username and password
    Given Navigate to Campus
    When The user types empty username and password
    And The user clicks on the login button
    Then The user verifies required message