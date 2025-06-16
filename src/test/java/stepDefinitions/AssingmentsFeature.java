package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.DialogContent;
import pages.TopNav;

public class AssingmentsFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    @And("the user selects the {string} section")
    public void theUserSelectsTheSection(String arg0) {
    }

    @When("the user clicks the {string} icon for a homework")
    public void theUserClicksTheIconForAHomework(String arg0) {

    }

    @Then("a rich text editor should appear on the screen")
    public void aRichTextEditorShouldAppearOnTheScreen() {
    }

    @And("the user enters the message content and uploads a file using the {string} option")
    public void theUserEntersTheMessageContentAndUploadsAFileUsingTheOption(String arg0) {
    }

    @And("the user chooses to save the submission as a draft by clicking the {string} button")
    public void theUserChoosesToSaveTheSubmissionAsADraftByClickingTheButton(String arg0) {
    }

    @Then("a confirmation message indicating success should be displayed")
    public void aConfirmationMessageIndicatingSuccessShouldBeDisplayed() {
    }

    @When("the user presses the {string} button within the text editor")
    public void theUserPressesTheButtonWithinTheTextEditor(String arg0) {
    }

    @And("the user confirms the action by clicking {string} in the confirmation dialog")
    public void theUserConfirmsTheActionByClickingInTheConfirmationDialog(String arg0) {
    }

    @Then("another success message should be shown confirming submission")
    public void anotherSuccessMessageShouldBeShownConfirmingSubmission() {
    }

    @Given("the user is on the detail view of the homework")
    public void theUserIsOnTheDetailViewOfTheHomework() {
    }

    @When("the user selects the {string} option")
    public void theUserSelectsTheOption(String arg0) {
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
}
