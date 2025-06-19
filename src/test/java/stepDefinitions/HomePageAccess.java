package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.*;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.Set;

public class HomePageAccess {
    TopNav tn = new TopNav();
    String campusPageWindow;

    @Given("The user is on the Campus home page")
    public void theUserIsOnTheCampusHomePage() {
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().contains(ConfigReader.getProperty("coursesURL")));
    }

    @When("The user clicks on the logo in the top left corner")
    public void theUserClicksOnTheLogoInTheTopLeftCorner() {
        campusPageWindow = GWD.getDriver().getWindowHandle();
        tn.wait.until(ExpectedConditions.visibilityOf(tn.homePageLogo));
        tn.myClick(tn.homePageLogo);
    }

    @Then("The user should be redirected to the home page")
    public void theUserShouldBeRedirectedToTheHomePage() {
        Set<String> allWindows = GWD.getDriver().getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(campusPageWindow)) {
                GWD.getDriver().switchTo().window(window);
                break;
            }
        }
    }

    @And("The user verifies that the home Page is displayed correctly")
    public void theUserVerifiesThatTheHomePageIsDisplayedCorrectly() {
        String currentURL = GWD.getDriver().getCurrentUrl();
        System.out.println("Redirected to URL: " + currentURL);
        Assert.assertTrue(currentURL.contains(ConfigReader.getProperty("technoStudyURL")));
    }
}