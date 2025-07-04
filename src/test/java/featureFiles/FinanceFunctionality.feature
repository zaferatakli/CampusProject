Feature: Finance Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully
    Given The user has been redirected to the my finance page
    And The user should be on the My Finance page

  Scenario: User makes a payment and verifies balance deduction
    Given The user memorizes balance.
    When The user clicks on their payment in processing
    Then The user verify that go to the Student Fee page
    And The user clicks on the following buttons to reach the pay button
      | stripe          |
      | payInFullButton |
      | payButton       |
    And The user enter the payment amount in the Amount field.
    And The user double clicks on the pay button
    When The user verifies that the field to enter credit card information has been opened
    And The user enters credit card details
    And The user clicks on the stripe payments button
    And The user sees the message of success
    Given The user has been redirected to the my finance page
    And The user should be on the My Finance page
    Then The user confirms the balance has decreased.

  Scenario: Displaying the installment payment form
    When The user clicks on their payment in processing
    And The user clicks on the following buttons to reach the pay button
      | stripe                  |
      | createInstallmentButton |
    Then The user views new installment payment form

  Scenario: Pay a course installment
    When The user clicks on their payment in processing
    Then The user verify that go to the Student Fee page
    And The user clicks on the following buttons to reach the pay button
      | stripe          |
      | payInFullButton |
      | payButton       |
    And The user enter the payment amount in the Amount field.
    And The user double clicks on the pay button
    When The user verifies that the field to enter credit card information has been opened
    And The user enters credit card details
    And The user clicks on the stripe payments button
    And The user sees the message of success

  Scenario: Download the payment information from the checkout page to your computer in excel or pdf format
    Given The user clicks on the button with three dots in the lower left corner
    And The user downloads the document by clicking the Excel Export button in the drop-down menu
    Given The user clicks on the button with three dots in the lower left corner
    And The user downloads the document by clicking the Pdf Export button in the drop-down menu