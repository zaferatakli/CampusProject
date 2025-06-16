package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.GWD;

import java.util.List;

public class AssingmentsFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();

    @Then("a rich text editor should appear on the screen")
    public void aRichTextEditorShouldAppearOnTheScreen() {
    }

    @Then("a confirmation message indicating success should be displayed")
    public void aConfirmationMessageIndicatingSuccessShouldBeDisplayed() {
    }

    @Then("another success message should be shown confirming submission")
    public void anotherSuccessMessageShouldBeShownConfirmingSubmission() {
    }

    @Given("the user is on the detail view of the homework")
    public void theUserIsOnTheDetailViewOfTheHomework() {
    }

    @Then("a text editor should be visible for entering a new submission")
    public void aTextEditorShouldBeVisibleForEnteringANewSubmission() {
    }

    @Given("the user has navigated to the Assignments page")
    public void theUserHasNavigatedToTheAssignmentsPage() {
    }

    @When("the user clicks the search icon on the default Assignments view")
    public void theUserClicksTheSearchIconOnTheDefaultAssignmentsView() {
    }

    @Then("the user should see a list displaying all assigned homework")
    public void theUserShouldSeeAListDisplayingAllAssignedHomework() {
    }

    @And("the user should be able to apply filters such as Course, Status, and Semester")
    public void theUserShouldBeAbleToApplyFiltersSuchAsCourseStatusAndSemester() {
    }

    @And("the user opens a dropdown menu to manage sorting options on the Assignments page")
    public void theUserOpensADropdownMenuToManageSortingOptionsOnTheAssignmentsPage() {
    }

    @And("the user sorts the results based on course, assignment type, date, or table columns")
    public void theUserSortsTheResultsBasedOnCourseAssignmentTypeDateOrTableColumns() {
    }

    @And("the user selects the Assignments section")
    public void theUserSelectsTheAssignmentsSection() {
        tn.wait.until(ExpectedConditions.visibilityOf(tn.assignmentsMenu));
        Assert.assertTrue(tn.assignmentsMenu.isDisplayed());
        tn.myClick(tn.assignmentsMenu);
    }

    @When("the user clicks the Submit icon for a homework")
    public void theUserClicksTheSubmitIconForAHomework() {
        Assert.assertTrue(dc.semesterButton.isDisplayed());
        dc.action.moveToElement(dc.semesterButton).click().build().perform();
        dc.myClick(dc.allButton);
        List<WebElement> submitButtonList = dc.submitIcons;
        for (int i = 0; i < submitButtonList.size(); i++) {
            dc.wait.until(ExpectedConditions.elementToBeClickable(submitButtonList.get(i)));
            Assert.assertTrue(submitButtonList.get(i).isDisplayed());
            dc.myClick(submitButtonList.get(i));
            GWD.getDriver().switchTo().frame(dc.homeworkIframe);
            dc.mySendKeys(dc.inputText, "Test");
            GWD.getDriver().switchTo().defaultContent();
            dc.myClick(dc.saveAsDraftButton);
            Assert.assertTrue(dc.submitSend.isDisplayed());
            dc.myClick(dc.submitSend);
            dc.myClick(dc.yesButton);
            tn.verifyContainsText(dc.successMessage, "Message successfully");
        }
    }

    @And("the user enters the message content and uploads a file using the Attach Files option")
    public void theUserEntersTheMessageContentAndUploadsAFileUsingTheAttachFilesOption() {
    }

    @And("the user chooses to save the submission as a draft by clicking the Save as Draft button")
    public void theUserChoosesToSaveTheSubmissionAsADraftByClickingTheSaveAsDraftButton() {
    }

    @When("the user presses the Submit button within the text editor")
    public void theUserPressesTheSubmitButtonWithinTheTextEditor() {
    }

    @And("the user confirms the action by clicking Yes in the confirmation dialog")
    public void theUserConfirmsTheActionByClickingYesInTheConfirmationDialog() {
    }

    @When("the user selects the New Submission option")
    public void theUserSelectsTheNewSubmissionOption() {
    }
}
