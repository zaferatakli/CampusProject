package stepDefinitions;

import io.cucumber.java.en.*;
import pages.DialogContent;
import pages.TopNav;

public class CalendarCourseControl {
    DialogContent dc = new DialogContent();
    TopNav tn = new TopNav();
    @When("The user checks the Weekly Course Plan page for Course Status indicators \\(P, S, E, C), Course Titles, and Instructor Names")
    public void theUserChecksTheWeeklyCoursePlanPageForCourseStatusIndicatorsPSECCourseTitlesAndInstructorNames() {
    }

    @And("The user selects a completed course labeled with \\(E)")
    public void theUserSelectsACompletedCourseLabeledWithE() {

    }

    @Then("The user confirms all available features in the displayed pop-up window")
    public void theUserConfirmsAllAvailableFeaturesInTheDisplayedPopUpWindow() {
    }

    @And("The user selects a course session that is scheduled for a future date")
    public void theUserSelectsACourseSessionThatIsScheduledForAFutureDate() {
    }

    @Then("The user checks that the Instructor's name, the scheduled Date and Time, and a relevant warning message are shown")
    public void theUserChecksThatTheInstructorSNameTheScheduledDateAndTimeAndARelevantWarningMessageAreShown() {
    }
}
