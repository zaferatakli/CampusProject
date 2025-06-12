Feature: Course Access on Calender Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Calendar Feature Check
    When  The user selects the Calendar option from the top navigation menu
      | calendar |
    Then  The user sees the current date along with the default Weekly Course Plan
    Then  The user observes the scheduled lesson icons (P, S, E, C) and their explanations
    Then  The user notices two navigational links for Weekly Course Plan and Calendar sections
    And   The user interacts with these navigation links

  Scenario: Navigating Forward and Backward on the Weekly Course Plan Page
    When  The user selects the Calendar option from the top navigation menu
      | calendar |

    Given The user has accessed the Weekly Course Plan view
    Then  The user should find navigation buttons to move between dates (Previous, Today, Next)
    When  The user taps on the navigation controls
      | previousButton |
      | nextButton     |
      | todayButton    |

    Given The user remains on the Weekly Course Plan page
    Then  The user is presented with a list of their assigned courses
    When  The user selects one of the courses
    Then  The user is shown detailed information for that specific course