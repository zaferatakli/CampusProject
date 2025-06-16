Feature:Assignments Feature Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Submitting homework and managing drafts
    And the user selects the "Assignments" section
    When the user clicks the "Submit" icon for a homework
    Then a rich text editor should appear on the screen
    And the user enters the message content and uploads a file using the "Attach Files" option
    And the user chooses to save the submission as a draft by clicking the "Save as Draft" button
    Then a confirmation message indicating success should be displayed
    When the user presses the "Submit" button within the text editor
    And the user confirms the action by clicking "Yes" in the confirmation dialog
    Then another success message should be shown confirming submission

  Scenario: Creating a new submission from the detail page
    Given the user is on the detail view of the homework
    When the user selects the "New Submission" option
    Then a text editor should be visible for entering a new submission


  Scenario: Searching and Sorting Assignments
    Given the user has navigated to the Assignments page
    And the user selects the "Assignments" section
    When the user clicks the search icon on the default Assignments view
    Then the user should see a list displaying all assigned homework
    And the user should be able to apply filters such as Course, Status, and Semester
    And the user opens a dropdown menu to manage sorting options on the Assignments page
    And the user sorts the results based on course, assignment type, date, or table columns