Feature: Profile feature

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
      Then User deletes the current photo and selects the new photo
      When Sees that the new photo has changed and exits the settings