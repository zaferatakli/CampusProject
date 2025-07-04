Feature: Accessing recording of an ended course

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Student watches the recording of an ended course
    Given  The student selects the Calendar option from the top nav menu
      | calendar |
    When The student navigates back until an ended course is visible
    And The student clicks on an ended course
    Then A pop-up with a "Recording" link should appear
    When The student clicks on the Recording link
    Then The video player with Play icon should be visible
    And The student should be able to start the video