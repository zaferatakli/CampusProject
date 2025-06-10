Feature: Course Control on Calender Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully
    When  The user selects the Calendar option from the top navigation menu
      | calendar |

  Scenario: PopUps Functionality
    When The user checks the Weekly Course Plan page for Course Status indicators (P, S, E, C), Course Titles, and Instructor Names
    And  The user selects a completed course labeled with (E)
    Then The user confirms all available features in the displayed pop-up window
      | topic        |
      | attachments  |
      | recentEvents |

    And  The user selects a course session that is scheduled for a future date
    Then The user checks that the Instructor's name, the scheduled Date and Time, and a relevant warning message are shown
