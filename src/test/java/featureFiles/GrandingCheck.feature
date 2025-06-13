Feature: Grading Feature - View Course Grades and Transcripts

  Background:
    Given Navigate to Campus
    When The user types username and password and click login button
    Then The user verifies login successfully

  Scenario: Student views grading page with course grade and transcript options
    Given The user is on the dashboard
    When The user clicks the "Grading" button
    Then The user should see "Course Grade", "Student Transcript", and "Transcript by Subject" buttons
    And Each button should be visible and clickable
    And The user can view content after clicking each section

  Scenario: Student downloads the Course Grade as a PDF
    Given The user is on the Grading page
    When The user clicks the "Course Grade" button
    And The user clicks the "Print" icon
    Then A PDF preview window should appear
    And The user should be able to click the "Download" icon
    And The PDF file should be saved locally

  Scenario: Student attempts to download Student Transcript
    Given The user is on the Grading page
    When The user clicks the "Student Transcript" button
    Then The "Print" icon should be visible
    And The user should be able to open and download the PDF




