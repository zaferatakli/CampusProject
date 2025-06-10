package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.TopNav;
import utilities.*;

import java.time.Duration;

public class MessageFunctionality {
    TopNav tn = new TopNav();
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
        tn.wait.until(ExpectedConditions.visibilityOf(tn.receiversButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.receiversButton));
        tn.action.moveToElement(tn.receiversButton).click().build().perform();
        tn.wait.until(ExpectedConditions.visibilityOf(tn.receiversCheckbox));
        tn.myClick(tn.receiversCheckbox);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.addAndCloseButton));
        tn.myClick(tn.addAndCloseButton);
    }

    @And("The user enter the subject of the message")
    public void theUserEnterTheSubjectOfTheMessage() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.subjectInput));
        tn.myClick(tn.subjectInput);
        tn.mySendKeys(tn.subjectInput, faker.lorem().word());
    }

    @And("The user enters the message content")
    public void theUserEntersTheMessageContent() {
        GWD.getDriver().switchTo().frame(tn.messageTextIframe);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.messageTextBody));
        tn.myClick(tn.messageTextBody);
        tn.mySendKeys(tn.messageTextBody, faker.lorem().sentence());
        GWD.getDriver().switchTo().defaultContent();
    }

    @And("The user attaches a file if necessary")
    public void theUserAttachesAFileIfNecessary() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.attachInput));
        tn.myClick(tn.attachInput);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.fromMyFiles));
        tn.myClick(tn.fromMyFiles);
        tn.action.moveToElement(tn.attachCheckbox).click().build().perform();
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.selectButton));
        tn.myClick(tn.selectButton);
    }

    @And("The user clicks on the Send button")
    public void theUserClicksOnTheSendButton() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.sendButton));
        tn.myClick(tn.sendButton);
    }

    @When("The user clicks on the Outbox tab")
    public void theUserClicksOnTheOutboxTab() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.outboxButton));
        tn.myClick(tn.outboxButton);
    }

    @And("The user clicks on the Move to Trash button")
    public void theUserClicksOnTheMoveToTrashButton() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.selectMessageButton));
        tn.myClick(tn.selectMessageButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.moveToTrashButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.moveToTrashButton));
        tn.action.pause(Duration.ofSeconds(3)).perform();
        tn.myClick(tn.moveToTrashButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.yesButton));
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.yesButton));
        tn.myClick(tn.yesButton);
    }

    @Then("The user verifies that the message is deleted successfully")
    public void theUserVerifiesThatTheMessageIsDeletedSuccessfully() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.successMessage));
        tn.verifyContainsText(tn.successMessage, "Message successfully");
    }

    @When("The user clicks on the Trash tab")
    public void theUserClicksOnTheTrashTab() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.trashButton));
        tn.myClick(tn.trashButton);
    }

    @And("The user selects the last deleted message and clicks the restore button")
    public void theUserSelectsTheLastDeletedMessageAndClicksTheRestoreButton() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.restoreButton));
        tn.myClick(tn.restoreButton);
    }

    @Then("The user verifies that the message is retrieved successfully")
    public void theUserVerifiesThatTheMessageIsRetrievedSuccessfully() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.successMessage));
        tn.verifyContainsText(tn.successMessage, "Message successfully");
    }
}