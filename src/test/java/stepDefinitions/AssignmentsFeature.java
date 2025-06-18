package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.GWD;

import java.time.Duration;

public class AssignmentsFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Given("the user is on the detail view of the homework")
    public void theUserIsOnTheDetailViewOfTheHomework() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.semesterButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.semesterButton));
        dc.action.moveToElement(dc.semesterButton).build().perform();
        dc.jsClick(dc.semesterButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.allButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.allButton));
        dc.myClick(dc.allButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.homeworkButton));
        dc.jsClick(dc.homeworkButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.newSubButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.newSubButton));
        dc.myClick(dc.newSubButton);
        dc.verifyContainsText(dc.attachInput, "Attach Files...");
    }

    @When("the user clicks the search icon on the default Assignments view")
    public void theUserClicksTheSearchIconOnTheDefaultAssignmentsView() {
        dc.jsClick(dc.searchButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.courseButton));
        dc.verifyContainsText(dc.courseButton, "Course");
        dc.verifyContainsText(dc.statusButton, "Status");
        dc.verifyContainsText(dc.semesterBtn, "Semester");

        dc.setWait(3);
        dc.jsClick(dc.defaultViewButton);
        dc.setWait(3);

        dc.jsClick(dc.showByCourse);
        dc.verifyContainsText(dc.showByCourse, "Show by Course");

        dc.jsClick(dc.showByCourse);
        dc.jsClick(dc.showByType);
        dc.verifyContainsText(dc.showByType, "Show by Type");

        dc.jsClick(dc.showByType);
        dc.jsClick(dc.showByDate);
        dc.verifyContainsText(dc.showByDate, "Show by Date");

        dc.jsClick(dc.showByDate);
        dc.jsClick(dc.showByChart);
        dc.verifyContainsText(dc.showByChart, "Show by Chart");
    }

    @And("the user selects the Assignments section")
    public void theUserSelectsTheAssignmentsSection() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.assignmentsMenu));
        Assert.assertTrue(tn.assignmentsMenu.isDisplayed());
        tn.myClick(tn.assignmentsMenu);
    }

    @When("the user clicks the Submit icon for a homework")
    public void theUserClicksTheSubmitIconForAHomework() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.semesterButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.semesterButton));
        dc.action.moveToElement(dc.semesterButton).build().perform();
        dc.jsClick(dc.semesterButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.allButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.allButton));
        dc.myClick(dc.allButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.submitIcons));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.submitIcons));
        dc.jsClick(dc.submitIcons);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.homeworkIframe));
        GWD.getDriver().switchTo().frame(dc.homeworkIframe);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.inputText));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.inputText));
        dc.jsClick(dc.inputText);

        dc.mySendKeys(dc.inputText, "Test");
        GWD.getDriver().switchTo().defaultContent();

        tn.wait.until(ExpectedConditions.visibilityOf(dc.attachInput));
        tn.myClick(dc.attachInput);

        tn.wait.until(ExpectedConditions.visibilityOf(dc.fromMyFiles));
        tn.myClick(dc.fromMyFiles);

        tn.action.pause(Duration.ofSeconds(2)).build().perform();

        for (int i = 1; i < 3; i++) {
            tn.action.sendKeys(Keys.TAB).build().perform();
        }
        tn.action.sendKeys(Keys.SPACE).build().perform();
        tn.action.pause(Duration.ofSeconds(1)).build().perform();
        tn.myClick(dc.selectButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.saveAsDraftButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.saveAsDraftButton));
        dc.jsClick(dc.saveAsDraftButton);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.submitSend));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.submitSend));
        dc.jsClick(dc.submitSend);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.yesButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.yesButton));
        dc.jsClick(dc.yesButton);
    }

    @And("the user enters the message content and uploads a file using the Attach Files option")
    public void theUserEntersTheMessageContentAndUploadsAFileUsingTheAttachFilesOption() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.attachInput));
        tn.myClick(dc.attachInput);
        tn.wait.until(ExpectedConditions.visibilityOf(dc.fromMyFiles));
        tn.myClick(dc.fromMyFiles);
        tn.action.pause(Duration.ofSeconds(2)).build().perform();

        for (int i = 1; i < 2; i++) {
            tn.action.sendKeys(Keys.TAB).build().perform();
        }

        tn.action.sendKeys(Keys.SPACE).build().perform();
        tn.action.pause(Duration.ofSeconds(1)).build().perform();
        tn.myClick(dc.selectButton);
    }
}