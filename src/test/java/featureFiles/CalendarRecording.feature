Feature: Accessing recording of an ended course

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Student watches the recording of an ended course
    Given  The user selects the Calendar option from the top nav menu
      | calendar |
    When the student navigates back until an ended course is visible
    And the student clicks on an ended course
    Then a pop-up with a "Recording" link should appear
    When the student clicks on the Recording link
    Then the video player with Play icon should be visible
    And the student should be able to start the video