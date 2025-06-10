Feature: Messages Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

    When The user hovers over from the hamburger menu and click hamburger menu
    And The user hovers over the messages tab in the drop-down menu

  Scenario:Message Access
    Then The user verifies that the message access is granted successfully

  Scenario:Messaging Send
    When The user clicks on the Send Message button
    And The user choice the recipient's name
    And The user enter the subject of the message
    And The user enters the message content
#   And The user attaches a file if necessary
    And The user clicks on the Send button

  Scenario:Messaging Delete
    When The user clicks on the Outbox tab
    And The user clicks on the Move to Trash button
    Then The user verifies that the message is deleted successfully

  Scenario:Messaging Retrieve
    When The user clicks on the Trash tab
    And The user selects the last deleted message and clicks the restore button
    Then The user verifies that the message is retrieved successfully