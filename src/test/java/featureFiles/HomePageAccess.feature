Feature: Techno Study Home Page Access With Logo

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Accessing the home page with the logo
    Given The user is on the Campus home page
    When The user clicks on the logo in the top left corner
    Then The user should be redirected to the home page
    And The user verifies that the home Page is displayed correctly