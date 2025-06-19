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
        dc.wait.until(ExpectedConditions.visibilityOf(dc.receiversButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.receiversButton));
        dc.action.moveToElement(dc.receiversButton).click().build().perform();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.receiversCheckbox));
        dc.myClick(dc.receiversCheckbox);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.addAndCloseButton));
        dc.myClick(dc.addAndCloseButton);
    }

    @And("The user enter the subject of the message")
    public void theUserEnterTheSubjectOfTheMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.subjectInput));
        dc.myClick(dc.subjectInput);
        dc.mySendKeys(dc.subjectInput, faker.lorem().word());
    }

    @And("The user enters the message content")
    public void theUserEntersTheMessageContent() {
        GWD.getDriver().switchTo().frame(dc.messageTextIframe);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.messageTextBody));
        dc.myClick(dc.messageTextBody);
        dc.mySendKeys(dc.messageTextBody, faker.lorem().sentence());
        GWD.getDriver().switchTo().defaultContent();
    }

    @And("The user attaches a file if necessary")
    public void theUserAttachesAFileIfNecessary() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.attachInput));
        dc.myClick(dc.attachInput);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.fromMyFiles));
        dc.myClick(dc.fromMyFiles);
        dc.action.pause(Duration.ofSeconds(2)).build().perform();
        for (int i = 1; i < 10; i++) {
            dc.action.sendKeys(Keys.TAB).build().perform();
        }
        dc.action.sendKeys(Keys.SPACE).build().perform();
        dc.action.pause(Duration.ofSeconds(3)).build().perform();
        for (int i = 1; i < 7; i++) {
            dc.action.sendKeys(Keys.TAB).build().perform();
        }

        dc.action.sendKeys(Keys.SPACE).build().perform();
        dc.action.pause(Duration.ofSeconds(1)).build().perform();
    }

    @And("The user clicks on the Send button")
    public void theUserClicksOnTheSendButton() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.sendButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.sendButton));
        dc.jsClick(dc.sendButton);
    }

    @When("The user clicks on the Outbox tab")
    public void theUserClicksOnTheOutboxTab() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.outboxButton));
        tn.myClick(tn.outboxButton);
    }

    @And("The user clicks on the Move to Trash button")
    public void theUserClicksOnTheMoveToTrashButton() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.selectMessageButton));
        dc.myClick(dc.selectMessageButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.moveToTrashButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.moveToTrashButton));
        dc.action.pause(Duration.ofSeconds(3)).perform();
        dc.myClick(dc.moveToTrashButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.yesButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.yesButton));
        dc.myClick(dc.yesButton);
    }

    @When("The user clicks on the Trash tab")
    public void theUserClicksOnTheTrashTab() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.trashButton));
        tn.myClick(tn.trashButton);
    }

    @And("The user selects the last deleted message and clicks the restore button")
    public void theUserSelectsTheLastDeletedMessageAndClicksTheRestoreButton() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.restoreButton));
        dc.myClick(dc.restoreButton);
    }
}