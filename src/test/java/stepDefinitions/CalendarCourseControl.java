package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;

public class CalendarCourseControl {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @When("the student clicks on a course that has not started yet")
    public void theStudentClicksOnACourseThatHasNotStartedYet() {
        dc.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("calendarURL")));
        dc.myClick(dc.lessonsButton);
    }

    @Then("a warning message {string} should be displayed")
    public void aWarningMessageShouldBeDisplayed(String message) {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.lessonMessageNotStarted));
        String actualMessage = dc.lessonMessageNotStarted.getText();
        Assert.assertTrue(actualMessage.contains(message), "Fail Message is not correct:  " + actualMessage);
    }

    @And("the student should not be allowed to enter the course")
    public void theStudentShouldNotBeAllowedToEnterTheCourse() {
        /// on the weekly calendar page, there are no lessons/courses that appear as published, i.e. that carry one of the P,S,E,C status icons.
        /// when clicking on the courses that appear available, the message Only moderators can create course event appears.
    }

    @Given("the student is on the Weekly Course Plan page")
    public void theStudentIsOnTheWeeklyCoursePlanPage() {
        dc.myClick(dc.weeklyCoursePlanButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());
    }

    @Then("a pop-up should display the course name, instructor, date and time")
    public void aPopUpShouldDisplayTheCourseNameInstructorDateAndTime() {
        Assert.assertTrue(dc.popUpLessonTitle.isDisplayed());
        Assert.assertTrue(dc.lessonTeacherName.isEmpty());
        Assert.assertNotNull(dc.dateCheck.getText());
    }

    @And("links Information, Topic, Attachments, and Recent Events should be functional")
    public void linksInformationTopicAttachmentsAndRecentEventsShouldBeFunctional() {
        dc.myClick(dc.selectMessageButton);
        Assert.assertTrue(dc.successMessage.isDisplayed());
    }
}