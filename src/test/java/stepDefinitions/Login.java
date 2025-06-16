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
        dc.wait.until(ExpectedConditions.visibilityOf(dc.loginCheck));
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
        dc.wait.until(ExpectedConditions.visibilityOf(dc.invalidMessage));
        dc.verifyContainsText(dc.invalidMessage, "Invalid username or password");
    }

    @When("The user types invalid username and valid password")
    public void theUserTypesInvalidUsernameAndValidPassword() {
        ConfigReader.updateProperty("invalidUsername");
        dc.mySendKeys(dc.usernameField, ConfigReader.getProperty("invalidUsername"));
        dc.mySendKeys(dc.passwordField, ConfigReader.getProperty("password"));
    }

    @When("The user types valid username and invalid password")
    public void theUserTypesValidUsernameAndInvalidPassword() {
        dc.mySendKeys(dc.usernameField, ConfigReader.getProperty("username"));
        ConfigReader.updateProperty("invalidPassword");
        dc.mySendKeys(dc.passwordField, ConfigReader.getProperty("invalidPassword"));
    }

    @When("The user types empty username and password")
    public void theUserTypesEmptyUsernameAndPassword() {
        dc.myClick(dc.loginButton);
    }

    @Then("The user verifies required message")
    public void theUserVerifiesRequiredMessage() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.emailRequiredMessage));
        String expectedEmailMessage = " E-mail is required ";
        String actualEmailMessage = dc.emailRequiredMessage.getText();
        if (actualEmailMessage.equals(expectedEmailMessage)) {
            dc.verifyContainsText(dc.emailRequiredMessage, " E-mail is required" );
        } else if (actualEmailMessage.equals(" E-posta gereklidir ")){
            dc.verifyContainsText(dc.emailRequiredMessage, " E-posta gereklidir ");
        }

        dc.wait.until(ExpectedConditions.visibilityOf(dc.passwordRequiredMessage));
        String expectedPasswordMessage = " Password is required ";
        String actualPasswordMessage = dc.passwordRequiredMessage.getText();
        if (actualPasswordMessage.equals(expectedPasswordMessage)) {
            dc.verifyContainsText(dc.passwordRequiredMessage, " Password is required ");
        } else if (actualPasswordMessage.equals(" Şifre gereklidir ")) {
            dc.verifyContainsText(dc.passwordRequiredMessage, " Şifre gereklidir ");
        }
    }
}