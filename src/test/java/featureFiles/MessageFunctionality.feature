Feature: Messages Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario:Message Access
    When The user hovers over the Messages tab from the hamburger menu and clicks
    And The user hovers over the messages tab in the drop-down menu
    Then The user verifies that the message access is granted successfully

  Scenario:Messaging Send
    When The user clicks on the Send Message button
    And The user enters the recipient's name
    And The user enter the subject of the message
    And The user enters the message content
    And The user attaches a file if necessary
    And The user clicks on the Send button

  Scenario:Messaging Delete
    When The user clicks on the Outbox tab
    And The user clicks on the Move to Trash button
    Then The user verifies that the message is deleted successfully

  Scenario:Messaging Retrieve
    When The user clicks on the Trash tab
    And The user selects the last deleted message and clicks the restore button
    Then The user verifies that the message is retrieved successfully