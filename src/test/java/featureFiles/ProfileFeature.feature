Feature: Profile Management Functionality

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario:Uploading your profile photo
    Given Clicks on the profile photo in the top right corner
    When Click on settings and there again click on the profile photo
    Then Clicks on the upload image here and selects the image on your computer

  Scenario:Change profile photo
    Given Clicks on the profile photo in the top right corner
    When Click on settings and there again click on the profile photo
    And User deletes the current photo and selects the new photo
    Given Clicks on the profile photo in the top right corner
    When Click on settings and there again click on the profile photo
    Then Sees that the new photo has changed and exits the settings

  Scenario:Change Theme
    Given Clicks on the profile photo in the top right corner
    When The user clicks on Settings and selects the desired theme colour from the Default theme option
    And This can be done with any two different colours
    Then After changing the theme, the user sees that the colours have changed and presses the save button