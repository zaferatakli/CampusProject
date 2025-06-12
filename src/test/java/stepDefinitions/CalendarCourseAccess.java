package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.GWD;

import java.util.List;

public class CalendarCourseAccess {
    DialogContent dc = new DialogContent();
    TopNav tn = new TopNav();

    @When("The user selects the Calendar option from the top navigation menu")
    public void theUserSelectsTheCalendarOptionFromTheTopNavigationMenu(DataTable calendar) {
        List<String> calendarButton = calendar.asList();

        for (int i = 0; i < calendarButton.size(); i++) {
            tn.myClick(tn.getWebElement(calendarButton.get(i)));
        }
    }

    @Then("The user sees the current date along with the default Weekly Course Plan")
    public void theUserSeesTheCurrentDateAlongWithTheDefaultWeeklyCoursePlan() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.dateCheck));
        Assert.assertTrue(dc.dateCheck.isDisplayed());
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());
    }

    @Then("The user observes the scheduled lesson icons \\(P, S, E, C) and their explanations")
    public void theUserObservesTheScheduledLessonIconsPSECAndTheirExplanations() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.publishedIcon));
        Assert.assertTrue(dc.publishedIcon.isDisplayed());
        dc.wait.until(ExpectedConditions.visibilityOf(dc.publishedDescription));
        Assert.assertTrue(dc.publishedDescription.isDisplayed());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.startedIcon));
        Assert.assertTrue(dc.startedIcon.isDisplayed());
        dc.wait.until(ExpectedConditions.visibilityOf(dc.startedDescription));
        Assert.assertTrue(dc.startedDescription.isDisplayed());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.endedIcon));
        Assert.assertTrue(dc.endedIcon.isDisplayed());
        dc.wait.until(ExpectedConditions.visibilityOf(dc.endedDescription));
        Assert.assertTrue(dc.endedDescription.isDisplayed());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.cancelledIcon));
        Assert.assertTrue(dc.cancelledIcon.isDisplayed());
        dc.wait.until(ExpectedConditions.visibilityOf(dc.cancelledDescription));
        Assert.assertTrue(dc.cancelledDescription.isDisplayed());
    }

    @Then("The user notices two navigational links for Weekly Course Plan and Calendar sections")
    public void theUserNoticesTwoNavigationalLinksForWeeklyCoursePlanAndCalendarSections() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyCoursePlanButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.weeklyCoursePlanButton));
        Assert.assertTrue(dc.weeklyCoursePlanButton.isDisplayed());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.calendarPageButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.calendarPageButton));
        Assert.assertTrue(dc.calendarPageButton.isDisplayed());
    }

    @And("The user interacts with these navigation links")
    public void theUserInteractsWithTheseNavigationLinks() {
        dc.myClick(dc.weeklyCoursePlanButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());

        dc.myClick(dc.calendarPageButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.calendarTableCheck));
        Assert.assertTrue(dc.calendarTableCheck.isDisplayed());
    }

    @Given("The user has accessed the Weekly Course Plan view")
    public void theUserHasAccessedTheWeeklyCoursePlanView() {
        dc.myClick(dc.weeklyCoursePlanButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());
    }

    @Then("The user should find navigation buttons to move between dates \\(Previous, Today, Next)")
    public void theUserShouldFindNavigationButtonsToMoveBetweenDatesPreviousTodayNext() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.previousButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.previousButton));
        Assert.assertTrue(dc.previousButton.isDisplayed());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.todayButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.todayButton));
        Assert.assertTrue(dc.todayButton.isDisplayed());

        dc.wait.until(ExpectedConditions.visibilityOf(dc.nextButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.nextButton));
        Assert.assertTrue(dc.nextButton.isDisplayed());
    }

    @When("The user taps on the navigation controls")
    public void theUserTapsOnTheNavigationControls(DataTable dateNavigation) {
        List<String> navigationButtons = dateNavigation.asList();

        for (int i = 0; i < navigationButtons.size(); i++) {
            dc.myClick(dc.getWebElement(navigationButtons.get(i)));
            dc.wait.until(ExpectedConditions.visibilityOf(dc.dateCheck));
            Assert.assertTrue(dc.dateCheck.isDisplayed());
        }
    }

    @Given("The user remains on the Weekly Course Plan page")
    public void theUserRemainsOnTheWeeklyCoursePlanPage() {
        dc.myClick(dc.weeklyCoursePlanButton);
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());
    }

    @Then("The user is presented with a list of their assigned courses")
    public void theUserIsPresentedWithAListOfTheirAssignedCourses() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.weeklyPlanTableCheck));
        Assert.assertTrue(dc.weeklyPlanTableCheck.isDisplayed());
    }

    @When("The user selects one of the courses")
    public void theUserSelectsOneOfTheCourses() {
        GWD.getDriver().navigate().refresh();
        dc.wait.until(ExpectedConditions.visibilityOf(dc.lessonsButton));
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.lessonsButton));
        dc.jsClick(dc.lessonsButton);
    }

    @Then("The user is shown detailed information for that specific course")
    public void theUserIsShownDetailedInformationForThatSpecificCourse() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.lessonMessage));
        Assert.assertTrue(dc.lessonMessage.isDisplayed());
        if (dc.lessonMessage.getText().contains("not been started")) {
            System.out.println("The lesson has not been started yet.");
        } else if (dc.lessonMessage.getText().contains("Only moderators can create course event")){
            System.out.println("Only moderators can create course event.");
        } else {
            System.out.println("Unexpected message: " + dc.lessonMessage.getText());
        }
    }
}
