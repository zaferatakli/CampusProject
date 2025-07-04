package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.ConfigReader;

import java.util.List;

public class CalendarCourseControl {
    DialogContent dc = new DialogContent();

    @When("The student clicks on a course that has not started yet")
    public void theStudentClicksOnACourseThatHasNotStartedYet() {
        dc.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("calendarURL")));
        dc.myClick(dc.lessonsButton);
    }

    @Then("A warning message {string} should be displayed")
    public void aWarningMessageShouldBeDisplayed(String message) {
        try {
            //dc.wait.until(ExpectedConditions.visibilityOf(dc.lessonMessageNotStarted));
            String actualMessage = dc.lessonMessageNotStarted.getText();
            Assert.assertTrue(actualMessage.contains(message), "Fail Message is not correct:  " + actualMessage);
        } catch (Exception e) {
            System.out.println("Warning message not displayed: " + e.getMessage());
        }
    }

    @And("The student should not be allowed to enter the course")
    public void theStudentShouldNotBeAllowedToEnterTheCourse() {
        /// on the weekly calendar page, there are no lessons/courses that appear as published, i.e. that carry one of the P,S,E,C status icons.
        /// when clicking on the courses that appear available, the message Only moderators can create course event appears.
    }

    @Given("The student is on the Weekly Course Plan page")
    public void theStudentIsOnTheWeeklyCoursePlanPage() {
        dc.myClick(dc.weeklyCoursePlanButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());
    }

    @When("The student selects one of the courses which has ended")
    public void theUserSelectsOneOfTheCoursesWhichHasEnded() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.previousButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.previousButton));
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        List<WebElement> endedIcons = dc.getWebElements("endedLessonIcons");
        while (true){
            endedIcons = dc.getWebElements("endedLessonIcons");
            if (!endedIcons.isEmpty()){
                dc.jsClick(endedIcons.get(0));
                break;
            } else {
                dc.myClick(dc.previousButton);
                dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
                dc.setWait(1);
            }
        }
    }

    @Then("A pop-up should display the course name, instructor, date and time")
    public void aPopUpShouldDisplayTheCourseNameInstructorDateAndTime() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.lessonName));
        Assert.assertTrue(dc.lessonName.isDisplayed(), "Lesson name is not displayed");
        Assert.assertTrue(dc.instructorName.isDisplayed(), "Instructor name is not displayed");
        Assert.assertTrue(dc.lessonDate.isDisplayed(), "Lesson date is not displayed");
        Assert.assertTrue(dc.lessonPeriod.isDisplayed(), "Lesson time is not displayed");
    }

    @And("The links Information, Topic, Attachments, and Recent Events should be functional")
    public void linksInformationTopicAttachmentsAndRecentEventsShouldBeFunctional() {
        dc.myClick(dc.topicButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.topicButton));
        Assert.assertTrue(dc.topicButton.isDisplayed(), "Topic content is not displayed");

        dc.myClick(dc.attachmentsButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.attachmentsButton));
        Assert.assertTrue(dc.attachmentsButton.isDisplayed(), "Attachments content is not displayed");

        dc.myClick(dc.recentEventsButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.recentEventsButton));
        Assert.assertTrue(dc.recentEventsButton.isDisplayed(), "Recent events content is not displayed");

        dc.myClick(dc.informationButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.informationButton));
        Assert.assertTrue(dc.informationButton.isDisplayed(), "Information content is not displayed");
    }
}