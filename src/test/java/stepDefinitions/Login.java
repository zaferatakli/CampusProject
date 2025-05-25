package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.DialogContent;
import utilities.ConfigReader;
import utilities.GWD;

public class Login {
    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigateToCampus() {
        GWD.getDriver().get(ConfigReader.getProperty("url"));
    }

    @When("The user types username and password and click login button")
    public void theUserTypesUsernameAndPasswordAndClickLoginButton() {
        dc.mySendKeys(dc.usernameField, ConfigReader.getProperty("username"));
        dc.mySendKeys(dc.passwordField, ConfigReader.getProperty("password"));
        dc.myClick(dc.loginButton);
    }

    @Then("The user verifies login successfully")
    public void theUserVerifiesLoginSuccessfully() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.loginCheck));
        dc.verifyContainsText(dc.loginCheck, "Welcome, Student_4 11A !");
    }

    @When("The user types invalid username and password")
    public void theUserTypesInvalidUsernameAndPassword() {
        ConfigReader.updateProperty("invalidUsername");
        dc.mySendKeys(dc.usernameField, ConfigReader.getProperty("invalidUsername"));
        ConfigReader.updateProperty("invalidPassword");
        dc.mySendKeys(dc.passwordField, ConfigReader.getProperty("invalidPassword"));
    }

    @And("The user clicks on the login button")
    public void theUserClicksOnTheLoginButton() {
        dc.myClick(dc.loginButton);
    }

    @Then("The user verifies warning message")
    public void theUserVerifiesWarningMessage() {
        GWD.getWait().until(ExpectedConditions.visibilityOf(dc.invalidMessage));
        dc.verifyContainsText(dc.invalidMessage, "Invalid username or password");
    }
}