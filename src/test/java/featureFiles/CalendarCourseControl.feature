Feature: Course Control on Calender Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully
    When  The user selects the Calendar option from the top navigation menu
      | calendar |

  Scenario: Scenario: Student cannot access a course that has not started yet
    When the student clicks on a course that has not started yet
    Then a warning message "Meeting has not been started yet" should be displayed
    And the student should not be allowed to enter the course

  Scenario: Student views course info from Weekly Course Plan
    Given the student is on the Weekly Course Plan page
    When The user selects one of the courses
    Then a pop-up should display the course name, instructor, date and time
    And links Information, Topic, Attachments, and Recent Events should be functional