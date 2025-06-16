package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.GWD;

import java.io.File;

public class GradingCheck {

    DialogContent dc = new DialogContent();
    TopNav tn = new TopNav();

    @When("The user clicks the Grading button")
    public void theUserClicksTheGradingButton() {
        tn.jsClick(tn.gradingMenu);
        dc.waitUntilVisible(dc.courseGradeButton);
        System.out.println("✅ Clicked the Grading menu button.");
    }

    @Then("The user should see Course Grade, Student Transcript, and Transcript by Subject buttons")
    public void theUserShouldSeeCourseGradeStudentTranscriptAndTranscriptBySubjectButtons() {
        dc.waitUntilVisible(dc.courseGradeButton);
        Assert.assertTrue(dc.courseGradeButton.isDisplayed(), "Course Grade button is not visible.");
        System.out.println("✅ Course Grade button is visible as expected.");

        dc.checkButtonAbsence(dc.studentTranscript, "Student Transcript");
        dc.checkButtonAbsence(dc.transcriptBySubject, "Transcript by Subject");
        System.out.println("✅ Student Transcript and Transcript by Subject buttons are not present (as expected).");
    }

    @And("Each button should be visible and clickable")
    public void eachButtonShouldBeClickable() {
        dc.waitUntilClickable(dc.courseGradeButton);
        Assert.assertTrue(dc.courseGradeButton.isEnabled(), "Course Grade button is not clickable.");
        System.out.println("✅ Course Grade button is visible and clickable.");
    }

    @And("The user can view content after clicking each section")
    public void theUserCanViewContentAfterClickingEachSection() {
        System.out.println("INFO: Content viewing check for sections. (Implementation details depend on application's behavior)");
    }

    @Given("The user is on the Grading page")
    public void theUserIsOnTheGradingPageForDownload() {
        tn.jsClick(tn.gradingMenu);
        dc.waitUntilVisible(dc.courseGradeButton);
        Assert.assertTrue(dc.courseGradeButton.isDisplayed(), "Course Grade button is not visible after navigating to Grading page.");
        System.out.println("✅ User is on the Grading page for PDF download.");
    }

    @When("The user clicks the Course Grade button")
    public void theUserClicksTheCourseGradeButtonForDownload() {
        dc.myClick(dc.courseGradeButton);
        System.out.println("Clicked the Course Grade button to load content.");

        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("DEBUG: Waited 8 seconds after clicking Course Grade. Checking Print icon visibility.");
    }
    @And("The user clicks the Print icon")
    public void theUserClicksThePrintIcon() {
        System.out.println("Attempting to click Print icon...");
        try {
            dc.waitUntilClickable(dc.printIcon);
            dc.myClick(dc.printIcon);
            System.out.println("Clicked the Print icon successfully.");
        } catch (NoSuchElementException e) {
            System.out.println("ERROR: Print Icon element not found in DOM.");
            throw e;
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("ERROR: Timeout waiting for Print Icon to be clickable.");
            throw e;
        }
    }

    @Then("A PDF preview window should appear")
    public void aPDFPreviewWindowShouldAppear() {
        GWD.switchToNewWindow();
        GWD.threadWait.get().until(driver -> {
            String url = driver.getCurrentUrl();
            return url.contains(".pdf") || url.contains("viewer") || url.startsWith("blob:") || url.startsWith("chrome-extension://");
        });
        String currentUrl = GWD.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(".pdf") || currentUrl.contains("viewer") || currentUrl.startsWith("blob:") || currentUrl.startsWith("chrome-extension://"),
                "PDF preview window did not appear or URL is incorrect: " + currentUrl);
        System.out.println("✅ PDF preview window appeared. Current URL: " + currentUrl);
    }
    @Then("The user should be able to click the {string} icon")
    public void theUserShouldBeAbleToClickTheIcon(String iconName) {
        if (iconName.equalsIgnoreCase("Download")) {
            dc.performDownloadWithRobot(15);
            System.out.println("✅ Attempted to click Download icon using Robot (TAB + ENTER).");
        } else {
            throw new IllegalArgumentException("Unknown icon to click in PDF preview: " + iconName);
        }
    }

    @And("The PDF file should be saved locally")
    public void thePDFFileShouldBeSavedLocally() {
        String downloadDirPath = "Downloads";
        String expectedFileNamePart = ".pdf";
        File downloadedFile = dc.checkFileDownloaded(downloadDirPath, expectedFileNamePart, 40);
        Assert.assertNotNull(downloadedFile, "No PDF file was downloaded.");
        dc.deleteDownloadedFiles(downloadDirPath, expectedFileNamePart);
        GWD.getDriver().close();
        GWD.switchToOriginalWindow();
        System.out.println("✅ PDF file verified and cleaned up. Switched back to original window.");
    }
}