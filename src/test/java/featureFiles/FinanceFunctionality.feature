Feature: Finance Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully
    Given The user has been redirected to the my finance page

  Scenario: Payment Feature on My Finance Page
    When The user clicks on the student information field
    Then The user clicks the Stripe button
    Then The user views the payment options
    When The user clicks the Pay option and views the amount information field
    And The user enters amount and clicks the Pay button
    Then The user views form to enter card details
    When The user enters card details and completes the payment
    Then The user views a message that the payment was successfully completed

    Then The user verifies that the payment has been completed
    When The user clicks the New Message button in the top right corner of the toolbar
    Then The user views the received message in the area

  Scenario: Pay a course installment


  Scenario: Download the payment information from the checkout page to your computer in excel or pdf format


