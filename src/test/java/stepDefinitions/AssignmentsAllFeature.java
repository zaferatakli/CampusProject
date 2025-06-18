package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
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
        Assert.assertEquals(GWD.getDriver().getCurrentUrl(),ConfigReader.getProperty("assignmentsURL"));
    }

    @Given("Student clicks on Discussion icon on the assignments page")
    public void studentClicksOnDiscussionIconOnTheAssignmentsPage() {
        tn.myClick(tn.assignmentsMenu);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.discussion));
        dc.myClick(dc.discussion);
        //GWD.getDriver().navigate().back();
    }

    @When("Student should see the chat page")
    public void studentShouldSeeTheChatPage() {
    }

    @Then("Student should click on the Contacts icon")
    public void studentShouldClickOnTheContactsIcon() {
    }

    @And("Student should send a message")
    public void studentShouldSendAMessage() {
    }

    @And("The student should be able to see that they sent a message")
    public void theStudentShouldBeAbleToSeeThatTheySentAMessage() {
    }

    @Given("Student clicks on shortcuts on the assignment")
    public void studentClicksOnShortcutsOnTheAssignment() {
    }

    @When("Student clicks anywhere in the assignment other than the icons")
    public void studentClicksAnywhereInTheAssignmentOtherThanTheIcons() {
    }

    @Then("Student sees Discussion icon")
    public void studentSeesDiscussionIcon() {
    }
}
