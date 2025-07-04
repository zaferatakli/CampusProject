package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.GWD;

import java.util.List;

public class CalendarRecording {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("The student selects the Calendar option from the top nav menu")
    public void theUserSelectsTheCalendarOptionFromTheTopNavMenu(DataTable calendar) {
        List<String> calendarButton = calendar.asList();

        for (int i = 0; i < calendarButton.size(); i++) {
            tn.myClick(tn.getWebElement(calendarButton.get(i)));
        }
    }

    @When("The student navigates back until an ended course is visible")
    public void theStudentNavigatesBackUntilAnEndedCourseIsVisible() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.previousButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.previousButton));
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        List<WebElement> endedIcons = dc.getWebElements("endedLessonIcons");
        while (true){
            endedIcons = dc.getWebElements("endedLessonIcons");
            if (!endedIcons.isEmpty()){
                break;
            } else {
                dc.myClick(dc.previousButton);
                dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
                dc.setWait(1);
            }
        }
    }

    @And("The student clicks on an ended course")
    public void theStudentClicksOnAnEndedCourse() {
        dc.jsClick(dc.getWebElements("endedLessonIcons").get(0));
    }

    @Then("A pop-up with a {string} link should appear")
    public void aPopUpWithALinkShouldAppear(String recordingText) {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.recordingButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.recordingButton));
        Assert.assertTrue(dc.recordingButton.getText().contains(recordingText));
    }

    @When("The student clicks on the Recording link")
    public void theStudentClicksOnTheRecordingLink() {
        dc.myClick(dc.recordingButton);
    }

    @Then("The video player with Play icon should be visible")
    public void theVideoPlayerWithPlayIconShouldBeVisible() {
        dc.wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.videoIframe));
        GWD.getDriver().switchTo().frame(0);
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.playVideoButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.playVideoButton));
        Assert.assertTrue(dc.playVideoButton.isDisplayed());
        dc.myClick(dc.playVideoButton);
    }

    @And("The student should be able to start the video")
    public void theStudentShouldBeAbleToStartTheVideo() {
        dc.setWait(15);
        GWD.getDriver().switchTo().parentFrame();
        dc.myClick(dc.videoCloseButton);
    }
}