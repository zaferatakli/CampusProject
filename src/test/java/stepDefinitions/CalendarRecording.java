package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.GWD;

import java.util.List;

public class CalendarRecording {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("The user selects the Calendar option from the top nav menu")
    public void theUserSelectsTheCalendarOptionFromTheTopNavMenu(DataTable calendar) {
        List<String> calendarButton = calendar.asList();

        for (int i = 0; i < calendarButton.size(); i++) {
            tn.myClick(tn.getWebElement(calendarButton.get(i)));
        }
    }

    @When("the student navigates back until an ended course is visible")
    public void theStudentNavigatesBackUntilAnEndedCourseIsVisible() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.previousButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.previousButton));
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        for (int i = 0; i < 10; i++) {
            if (!dc.endedLessonIcons.isEmpty()) {
                break;
            }
            dc.myClick(dc.previousButton);
            dc.setWait(1);
        }
        Assert.assertTrue(!dc.endedLessonIcons.isEmpty());
    }

    @And("the student clicks on an ended course")
    public void theStudentClicksOnAnEndedCourse() {
        dc.jsClick(dc.getWebElements("endedLessonIcons").get(0));
    }

    @Then("a pop-up with a {string} link should appear")
    public void aPopUpWithALinkShouldAppear(String recordingText) {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.recordingButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.recordingButton));
        Assert.assertTrue(dc.recordingButton.getText().contains(recordingText));
    }

    @When("the student clicks on the Recording link")
    public void theStudentClicksOnTheRecordingLink() {
        dc.myClick(dc.recordingButton);
    }

    @Then("the video player with Play icon should be visible")
    public void theVideoPlayerWithPlayIconShouldBeVisible() {
        dc.wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.videoIframe));
        GWD.getDriver().switchTo().frame(0);
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.playVideoButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.playVideoButton));
        Assert.assertTrue(dc.playVideoButton.isDisplayed());
        dc.myClick(dc.playVideoButton);
    }

    @And("the student should be able to start the video")
    public void theStudentShouldBeAbleToStartTheVideo() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.videoTimer));
        boolean reached15Sec = false;
        for (int i = 0; i < 20; i++) {
            dc.setWait(1);
            String timeText = dc.videoTimer.getText().trim();
            if (timeText.equals("00:15")) {
                reached15Sec = true;
                break;
            }
        }

        Assert.assertTrue(reached15Sec);
        GWD.getDriver().switchTo().parentFrame();
        dc.myClick(dc.videoCloseButton);
    }
}