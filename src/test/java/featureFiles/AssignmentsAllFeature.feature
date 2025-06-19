Feature:Assignments All Feature Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Access all assigned tasks
    Given  User should be able to see Assignment link
    When User hover-overs the Assignment link
    Then User clicks on Assignment link

  Scenario: Homework submission procedures
    Given Student clicks on Discussion icon on the assignments page
    When Student should see the chat page
    Then Student should click on the Contacts icon
    And Student should send a message
    And The student should be able to see that they sent a message

  Scenario: Assignment shortcuts in the section
    Given Student clicks on shortcuts on the assignment
    When Student clicks anywhere in the assignment other than the icons
    Then Student sees Discussion icon

  Scenario: Submitting homework and managing drafts
    When the user clicks the Submit icon for a homework
    And the user enters the message content and uploads a file using the Attach Files option

  Scenario: Creating a new submission from the detail page
    Given the user is on the detail view of the homework

  Scenario: Searching and Sorting Assignments
    When the user clicks the search icon on the default Assignments view