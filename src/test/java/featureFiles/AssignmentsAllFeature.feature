Feature:Assignments All Feature Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Access all assigned tasks
      Given  User should be able to see Assignment link
      When User hover-overs the Assignment link
      Then User clicks on Assignment link

  Scenario: Homework submission procedures
        Given Student clicks on Discussion icon on the assignments page
        When Student should see the chat page
        Then Student should click on the Contacts icon
        And Student should send a message
        And The student should be able to see that they sent a message

  Scenario: Assignment bölümündeki kısa yollar
          Given Student clicks on shortcuts on the assignment
          When Student clicks anywhere in the assignment other than the icons
          Then Student sees Discussion icon
