package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;

public class MessageFunctionality {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @When("The user hovers over the Messages tab from the hamburger menu and clicks")
    public void theUserHoversOverTheMessagesTabFromTheHamburgerMenuAndClicks() {
    }

    @And("The user hovers over the messages tab in the drop-down menu")
    public void theUserHoversOverTheMessagesTabInTheDropDownMenu() {
    }

    @Then("The user verifies that the message access is granted successfully")
    public void theUserVerifiesThatTheMessageAccessIsGrantedSuccessfully() {
    }

    @When("The user clicks on the Send Message button")
    public void theUserClicksOnTheSendMessageButton() {
    }

    @And("The user enters the recipient's name")
    public void theUserEntersTheRecipientSName() {
    }

    @And("The user enter the subject of the message")
    public void theUserEnterTheSubjectOfTheMessage() {
    }

    @And("The user enters the message content")
    public void theUserEntersTheMessageContent() {
    }

    @And("The user attaches a file if necessary")
    public void theUserAttachesAFileIfNecessary() {
    }

    @And("The user clicks on the Send button")
    public void theUserClicksOnTheSendButton() {
    }

    @When("The user clicks on the Outbox tab")
    public void theUserClicksOnTheOutboxTab() {
    }

    @And("The user clicks on the Move to Trash button")
    public void theUserClicksOnTheMoveToTrashButton() {
    }

    @Then("The user verifies that the message is deleted successfully")
    public void theUserVerifiesThatTheMessageIsDeletedSuccessfully() {
    }

    @When("The user clicks on the Trash tab")
    public void theUserClicksOnTheTrashTab() {
    }

    @And("The user selects the last deleted message and clicks the restore button")
    public void theUserSelectsTheLastDeletedMessageAndClicksTheRestoreButton() {
    }

    @Then("The user verifies that the message is retrieved successfully")
    public void theUserVerifiesThatTheMessageIsRetrievedSuccessfully() {
    }
}