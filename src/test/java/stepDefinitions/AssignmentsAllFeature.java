package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.ConfigReader;
import utilities.GWD;

import java.time.Duration;

public class AssignmentsAllFeature {
    DialogContent dc = new DialogContent();
    TopNav tn = new TopNav();

    @Given("User should be able to see Assignment link")
    public void userShouldBeAbleToSeeAssignmentLink() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.assignmentsMenu));
        Assert.assertTrue(tn.assignmentsMenu.isDisplayed());
    }

    @When("User hover-overs the Assignment link")
    public void userHoverOversTheAssignmentLink() {
        tn.hoverOver(tn.assignmentsMenu);
        Assert.assertTrue(tn.assignmentJobs.isDisplayed());
    }

    @Then("User clicks on Assignment link")
    public void userClicksOnAssignmentLink() {
        tn.myClick(tn.assignmentsMenu);
        tn.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("assignmentsURL")));
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(), ConfigReader.getProperty("assignmentsURL"));
    }

    @Given("Student clicks on Discussion icon on the assignments page")
    public void studentClicksOnDiscussionIconOnTheAssignmentsPage() {
        tn.myClick(tn.assignmentsMenu);
        dc.jsClick(dc.discussion);
    }

    @When("Student should see the chat page")
    public void studentShouldSeeTheChatPage() {
        dc.moveToElementAndClick(dc.chats);
    }

    @Then("Student should click on the Contacts icon")
    public void studentShouldClickOnTheContactsIcon() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.contacts));
        dc.myClick(dc.contacts);
    }

    @And("Student should send a message")
    public void studentShouldSendAMessage() {
        dc.action.moveToElement(dc.textArea).click().sendKeys("Deneme").build().perform();
        dc.moveToElementAndClick(dc.chatSendButton);
    }

    @And("The student should be able to see that they sent a message")
    public void theStudentShouldBeAbleToSeeThatTheySentAMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.messageTrue));
        Assert.assertTrue(dc.messageTrue.isDisplayed());
    }

    @Given("Student clicks on shortcuts on the assignment")
    public void studentClicksOnShortcutsOnTheAssignment() {
        tn.myClick(tn.assignmentsMenu);
        dc.moveToElementAndClick(dc.infoAssignment);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.description));
        GWD.getDriver().navigate().back();
        dc.moveToElementAndClick(dc.submitAssignment);
        GWD.getDriver().navigate().back();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.discussion));
        dc.action.moveToElement(dc.discussion).build().perform();
        dc.clickAndClose(dc.discussion, dc.chats);
        dc.moveToElementAndClick(dc.starAssignment);
        dc.moveToElementAndClick(dc.showMarked);
        dc.moveToElementAndClick(dc.starAssignment);
        dc.moveToElementAndClick(dc.showMarked);
    }

    @When("Student clicks anywhere in the assignment other than the icons")
    public void studentClicksAnywhereInTheAssignmentOtherThanTheIcons() {
        dc.myClick(dc.centerPush);
        GWD.getDriver().navigate().back();
    }

    @Then("Student sees Discussion icon")
    public void studentSeesDiscussionIcon() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.showMarked));
        dc.moveToElementAndClick(dc.showMarked);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.discussion));
        Assert.assertTrue(dc.discussion.isDisplayed());
    }

    @When("The user goes to the assignment page, clicks the search button, checks the necessary icons on the page that opens")
    public void theUserGoesToTheAssignmentPageClicksTheSearchButtonChecksTheNecessaryIconsOnThePageThatOpens() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.assignmentsMenu));
        Assert.assertTrue(tn.assignmentsMenu.isDisplayed());

        tn.myClick(tn.assignmentsMenu);
        dc.jsClick(dc.searchButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.courseButton));
        dc.verifyContainsText(dc.courseButton, "Course");
        dc.verifyContainsText(dc.statusButton, "Status");
        dc.verifyContainsText(dc.semesterBtn, "Semester");
    }

    @And("User controls the filtering options in the assignment tab")
    public void userControlsTheFilteringOptionsInTheAssignmentTab() {
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

    @When("User displays the assignments page")
    public void userDisplaysTheAssignmentsPage() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.assignmentsMenu));
        Assert.assertTrue(tn.assignmentsMenu.isDisplayed());
        tn.myClick(tn.assignmentsMenu);

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

    @And("The user clicks on the first of the assignments and sends a message")
    public void theUserClicksOnTheFirstOfTheAssignmentsAndSendsAMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.homeworkIframe));
        GWD.getDriver().switchTo().frame(dc.homeworkIframe);

        dc.wait.until(ExpectedConditions.visibilityOf(dc.inputText));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.inputText));
        dc.jsClick(dc.inputText);

        tn.action.pause(Duration.ofSeconds(2)).build().perform();

        dc.mySendKeys(dc.inputText, "Test");
        GWD.getDriver().switchTo().defaultContent();

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

    @When("The user clicks the Submit icon for a homework")
    public void theUserClicksTheSubmitIconForAHomework() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.assignmentsMenu));
        Assert.assertTrue(tn.assignmentsMenu.isDisplayed());
        tn.myClick(tn.assignmentsMenu);
    }

    @And("The user enters the message content and uploads a file using the Attach Files option")
    public void theUserEntersTheMessageContentAndUploadsAFileUsingTheAttachFilesOption() {
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
}