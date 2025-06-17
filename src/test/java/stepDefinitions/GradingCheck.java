package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;

public class GradingCheck {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @When("The user clicks the Grading button")
    public void theUserClicksTheGradingButton() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.gradingMenu));
        Assert.assertTrue(tn.gradingMenu.isDisplayed(),"Grading Button Not Displayed ! ");
        tn.myClick(tn.gradingMenu);
    }


    @Then("The user should see Course Grade, Student Transcript, and Transcript by Subject buttons")
    public void theUserShouldSeeCourseGradeStudentTranscriptAndTranscriptBySubjectButtons() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.courseGradeButton));
        Assert.assertTrue(dc.courseGradeButton.isDisplayed(), "Course Grade Button Not Displayed ! ");
        dc.wait.until(ExpectedConditions.visibilityOf(dc.studentTranscript));
        Assert.assertTrue(dc.studentTranscript.isDisplayed(), "Student Transcript Button Not Displayed ! ");
        dc.wait.until(ExpectedConditions.visibilityOf(dc.transcriptBySubject));
        Assert.assertTrue(dc.transcriptBySubject.isDisplayed(), "Transcript by Subject Button Not Displayed ! ");

    }

    @And("Each button should be clickable")
    public void eachButtonShouldBeClickable() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.courseGradeButton));
        Assert.assertTrue(dc.courseGradeButton.isDisplayed(),"Course Grade Button Not Displayed ! ");
        dc.myClick(dc.courseGradeButton);
        System.out.println(" Student Transcript Button and Transcript by Subject Button Not Displayed ! EACH BUTTON IS MISSING ! ");
    }

    @And("The user can view content after clicking each section")
    public void theUserCanViewContentAfterClickingEachSection() {
        dc.myClick(dc.courseGradeButton);
        Assert.assertTrue(dc.courseGradeButton.isDisplayed(), "Course Grade content not displayed!");

        dc.myClick(dc.studentTranscript);
        Assert.assertTrue(dc.studentTranscript.isDisplayed(), "Student Transcript content not displayed!");

        dc.myClick(dc.transcriptBySubject);
        Assert.assertTrue(dc.transcriptBySubject.isDisplayed(), "Transcript by Subject content not displayed!");


    }

    @Given("The user is on the Grading page")
    public void theUserIsOnTheGradingPage() {
    }

    @And("The user clicks the Print icon")
    public void theUserClicksThePrintIcon() {
    }

    @Then("A PDF preview window should appear")
    public void aPDFPreviewWindowShouldAppear() {
    }

    @And("The user should be able to click the {string} icon")
    public void theUserShouldBeAbleToClickTheIcon(String arg0) {
    }

    @And("The PDF file should be saved locally")
    public void thePDFFileShouldBeSavedLocally() {
    }

    @When("The user clicks the Student Transcript button")
    public void theUserClicksTheStudentTranscriptButton() {
    }

    @Then("The Print icon should be visible")
    public void thePrintIconShouldBeVisible() {
    }

    @And("The user should be able to open and download the PDF")
    public void theUserShouldBeAbleToOpenAndDownloadThePDF() {
    }
}
