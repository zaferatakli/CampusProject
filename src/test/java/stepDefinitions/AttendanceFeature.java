package stepDefinitions;

import io.cucumber.java.en.*;
import net.datafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;

import java.time.Duration;

public class AttendanceFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    Faker faker = new Faker();

    @Given("The user navigates to the Attendance section from the homepage")
    public void theUserNavigatesToTheAttendanceSectionFromTheHomepage() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.attendanceMenu));
        tn.myClick(tn.attendanceMenu);
    }

    @When("The user clicks the Attendance Excuses button")
    public void theUserClicksTheAttendanceExcusesButton() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.attendanceExcusesButton));
        dc.jsClick(dc.attendanceExcusesButton);
    }

    @Then("The system navigates to the Excuse Submission page")
    public void theSystemNavigatesToTheExcuseSubmissionPage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.addAttendanceExcusesIcon));
        Assert.assertTrue(dc.addAttendanceExcusesIcon.isDisplayed());
    }

    @And("The user clicks the Add Attendance Excuse button")
    public void theUserClicksTheAddAttendanceExcuseButton() {
        dc.myClick(dc.addAttendanceExcusesIcon);
    }

    @When("The user enters a reason for absence and uploads a supporting document")
    public void theUserEntersAReasonForAbsenceAndUploadsASupportingDocument() {
        tn.myClick(dc.inputMessageAttendance);
        tn.mySendKeys(dc.inputMessageAttendance, faker.lorem().sentence());

        tn.wait.until(ExpectedConditions.visibilityOf(dc.attachInput));
        tn.myClick(dc.attachInput);

        tn.wait.until(ExpectedConditions.visibilityOf(dc.fromMyFiles));
        tn.myClick(dc.fromMyFiles);
        tn.action.pause(Duration.ofSeconds(2)).perform();

        for (int i = 1; i < 3; i++) {
            tn.action.sendKeys(Keys.TAB).perform();
        }

        tn.action.sendKeys(Keys.SPACE).perform();
        tn.action.pause(Duration.ofSeconds(1)).perform();
        dc.myClick(dc.select);
    }

    @And("Submits the excuse form")
    public void submitsTheExcuseForm() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(dc.sendButton));
        dc.jsClick(dc.sendButton);
    }
}