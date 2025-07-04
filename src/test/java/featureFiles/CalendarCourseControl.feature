Feature: Course Control on Calender Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully
    When  The user selects the Calendar option from the top navigation menu
      | calendar |

  Scenario: Scenario: Student cannot access a course that has not started yet
    When The student clicks on a course that has not started yet
    Then A warning message "Meeting has not been started yet" should be displayed
    And The student should not be allowed to enter the course

  Scenario: Student views course info from Weekly Course Plan
    Given The student is on the Weekly Course Plan page
    When The student selects one of the courses which has ended
    Then A pop-up should display the course name, instructor, date and time
    And The links Information, Topic, Attachments, and Recent Events should be functional