package stepDefinitions;

import io.cucumber.java.en.*;
import net.datafaker.Faker;
import pages.DialogContent;
import pages.TopNav;

public class AttendanceFeature {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    Faker faker = new Faker();

    @Given("the user selects the Attendance option from the homepage,")
    public void theUserSelectsTheAttendanceOptionFromTheHomepage() {
    }

    @Then("the system navigates the user to the Excuse Submission page,")
    public void theSystemNavigatesTheUserToTheExcuseSubmissionPage() {
    }

    @When("the user enters a reason for absence and uploads a related document,")
    public void theUserEntersAReasonForAbsenceAndUploadsARelatedDocument() {
    }

    @And("proceeds to send the excuse form,")
    public void proceedsToSendTheExcuseForm() {
    }

    @Then("a confirmation notice is displayed to the user.")
    public void aConfirmationNoticeIsDisplayedToTheUser() {
    }
}