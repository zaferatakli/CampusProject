package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.ConfigReader;
import utilities.GWD;

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
        dc.myClick(dc.discussion);
    }

    @When("Student should see the chat page")
    public void studentShouldSeeTheChatPage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.chats));
        dc.myClick(dc.chats);
    }

    @Then("Student should click on the Contacts icon")
    public void studentShouldClickOnTheContactsIcon() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.contacts));
        dc.myClick(dc.contacts);
    }

    @And("Student should send a message")
    public void studentShouldSendAMessage() {
        dc.mySendKeys(dc.textArea, "Deneme");
        dc.myClick(dc.ChatSendButton);
    }

    @And("The student should be able to see that they sent a message")
    public void theStudentShouldBeAbleToSeeThatTheySentAMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.messageTrue));
        Assert.assertTrue(dc.messageTrue.isDisplayed());
    }

    @Given("Student clicks on shortcuts on the assignment")
    public void studentClicksOnShortcutsOnTheAssignment() {
        tn.myClick(tn.assignmentsMenu);
        dc.myClick(dc.infoAssignment);
        GWD.getDriver().navigate().back();
        dc.myClick(dc.submitAssignment);
        GWD.getDriver().navigate().back();
        dc.myClick(dc.discussion);
        GWD.getDriver().navigate().back();
        dc.myClick(dc.starAssignment);
        dc.myClick(dc.showMarked);
        GWD.getDriver().navigate().back();
    }

    @When("Student clicks anywhere in the assignment other than the icons")
    public void studentClicksAnywhereInTheAssignmentOtherThanTheIcons() {
        dc.myClick(dc.centerPush);
        GWD.getDriver().navigate().back();
    }

    @Then("Student sees Discussion icon")
    public void studentSeesDiscussionIcon() {
        Assert.assertTrue(dc.discussion.isDisplayed());
    }
}
