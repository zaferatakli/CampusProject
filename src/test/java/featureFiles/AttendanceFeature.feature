Feature: To excuse absence from a course.

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Submitting an Attendance Excuse
    Given the user selects the Attendance option from the homepage,
    Then the system navigates the user to the Excuse Submission page,
    When the user enters a reason for absence and uploads a related document,
    And proceeds to send the excuse form,
    Then a confirmation notice is displayed to the user.