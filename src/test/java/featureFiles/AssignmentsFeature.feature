Feature:Assignments Feature Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully
    And the user selects the Assignments section

  Scenario: Submitting homework and managing drafts
    When the user clicks the Submit icon for a homework
    And the user enters the message content and uploads a file using the Attach Files option

  Scenario: Creating a new submission from the detail page
    Given the user is on the detail view of the homework

  Scenario: Searching and Sorting Assignments
    When the user clicks the search icon on the default Assignments view