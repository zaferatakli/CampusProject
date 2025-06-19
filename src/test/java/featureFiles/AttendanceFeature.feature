Feature: To excuse absence from a course.

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Submitting an Attendance Excuse
    Given The user navigates to the Attendance section from the homepage
    When The user clicks the Attendance Excuses button
    Then The system navigates to the Excuse Submission page
    And The user clicks the Add Attendance Excuse button
    When The user enters a reason for absence and uploads a supporting document
    And Submits the excuse form