package stepDefinitions;

import io.cucumber.java.en.*;
import net.datafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.*;
import utilities.*;

import java.time.Duration;

public class MessageFunctionality {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    Faker faker = new Faker();

    @When("The user hovers over from the hamburger menu and click hamburger menu")
    public void theUserHoversOverTheMessagesTabFromTheHamburgerMenuAndClicks() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.hamburgerMenuButton));
        tn.myClick(tn.hamburgerMenuButton);
    }

    @And("The user hovers over the messages tab in the drop-down menu")
    public void theUserHoversOverTheMessagesTabInTheDropDownMenu() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.messagingButton));
        tn.hoverOver(tn.messagingButton);
    }

    @Then("The user verifies that the message access is granted successfully")
    public void theUserVerifiesThatTheMessageAccessIsGrantedSuccessfully() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.messagingSubMenuList.get(0)));
        tn.verifyContainsText(tn.messagingSubMenuList.get(0), "Send Message");
        tn.verifyContainsText(tn.messagingSubMenuList.get(1), "Inbox");
        tn.verifyContainsText(tn.messagingSubMenuList.get(2), "Outbox");
        tn.verifyContainsText(tn.messagingSubMenuList.get(3), "Trash");
    }

    @When("The user clicks on the Send Message button")
    public void theUserClicksOnTheSendMessageButton() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.sendMessageButton));
        tn.hoverOver(tn.sendMessageButton);
        tn.myClick(tn.sendMessageButton);
    }

    @And("The user choice the recipient's name")
    public void theUserEntersTheRecipientSName() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.receiversButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(dc.receiversButton));
        tn.action.moveToElement(dc.receiversButton).click().build().perform();
        tn.wait.until(ExpectedConditions.visibilityOf(dc.receiversCheckbox));
        tn.myClick(dc.receiversCheckbox);
        tn.wait.until(ExpectedConditions.visibilityOf(dc.addAndCloseButton));
        tn.myClick(dc.addAndCloseButton);
    }

    @And("The user enter the subject of the message")
    public void theUserEnterTheSubjectOfTheMessage() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.subjectInput));
        tn.myClick(dc.subjectInput);
        tn.mySendKeys(dc.subjectInput, faker.lorem().word());
    }

    @And("The user enters the message content")
    public void theUserEntersTheMessageContent() {
        GWD.getDriver().switchTo().frame(dc.messageTextIframe);
        tn.wait.until(ExpectedConditions.visibilityOf(dc.messageTextBody));
        tn.myClick(dc.messageTextBody);
        tn.mySendKeys(dc.messageTextBody, faker.lorem().sentence());
        GWD.getDriver().switchTo().defaultContent();
    }

    @And("The user attaches a file if necessary")
    public void theUserAttachesAFileIfNecessary() {
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
        for (int i = 1; i < 14; i++) {
            tn.action.sendKeys(Keys.TAB).build().perform();
        }
        tn.action.sendKeys(Keys.SPACE).build().perform();
        tn.action.pause(Duration.ofSeconds(1)).build().perform();
    }

    @And("The user clicks on the Send button")
    public void theUserClicksOnTheSendButton() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.sendButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(dc.sendButton));
        tn.jsClick(dc.sendButton);
    }

    @When("The user clicks on the Outbox tab")
    public void theUserClicksOnTheOutboxTab() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.outboxButton));
        tn.myClick(tn.outboxButton);
    }

    @And("The user clicks on the Move to Trash button")
    public void theUserClicksOnTheMoveToTrashButton() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.selectMessageButton));
        tn.myClick(dc.selectMessageButton);
        tn.wait.until(ExpectedConditions.visibilityOf(dc.moveToTrashButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(dc.moveToTrashButton));
        tn.action.pause(Duration.ofSeconds(3)).perform();
        tn.myClick(dc.moveToTrashButton);
        tn.wait.until(ExpectedConditions.visibilityOf(dc.yesButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(dc.yesButton));
        tn.myClick(dc.yesButton);
    }

    @Then("The user verifies that the message is deleted successfully")
    public void theUserVerifiesThatTheMessageIsDeletedSuccessfully() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.successMessage));
        tn.verifyContainsText(dc.successMessage, "Message successfully");
    }

    @When("The user clicks on the Trash tab")
    public void theUserClicksOnTheTrashTab() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.trashButton));
        tn.myClick(tn.trashButton);
    }

    @And("The user selects the last deleted message and clicks the restore button")
    public void theUserSelectsTheLastDeletedMessageAndClicksTheRestoreButton() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.restoreButton));
        tn.myClick(dc.restoreButton);
    }

    @Then("The user verifies that the message is retrieved successfully")
    public void theUserVerifiesThatTheMessageIsRetrievedSuccessfully() {
        tn.wait.until(ExpectedConditions.visibilityOf(dc.successMessage));
        tn.verifyContainsText(dc.successMessage, "Message successfully");
    }
}