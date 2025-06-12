package stepDefinitions;

import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

public class FinanceFunctionality {
    TopNav tn = new TopNav();
    DialogContent dc = new DialogContent();
    @Given("The user has been redirected to the my finance page")
    public void theUserHasBeenRedirectedToTheMyFinancePage() {
        tn.wait.until(ExpectedConditions.elementToBeClickable(tn.hamburgerMenuButton));
        tn.myClick(tn.hamburgerMenuButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.messagingButton));
        tn.hoverOver(tn.financeButton);
        tn.wait.until(ExpectedConditions.visibilityOf(tn.myFinanceButton));
        tn.myClick(tn.myFinanceButton);
        dc.wait.until(ExpectedConditions.urlToBe(ConfigReader.getProperty("myFinanceURL")));
        Assert.assertTrue(GWD.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("myFinanceURL")));
    }

    @When("The user clicks on the student information field")
    public void theUserClicksOnTheStudentInformationField() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.viewButton));
        dc.myClick(dc.viewButton);
    }

    @Then("The user clicks the Stripe button")
    public void theUserClicksTheStripeButton() {
        dc.wait.until(ExpectedConditions.elementToBeClickable(dc.stripeButton));
        dc.myClick(dc.stripeButton);
    }

    @Then("The user views the payment options")
    public void theUserViewsThePaymentOptions() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.payInFullButton));
        Assert.assertTrue(dc.payInFullButton.isDisplayed(), "Pay in full button are not displayed");
        Assert.assertTrue(dc.createInstallmentButton.isDisplayed(), "Pay in Create installment options are not displayed");

    }

    @When("The user clicks the Pay option and views the amount information field")
    public void theUserClicksThePayOptionAndViewsTheAmountInformationField() {
    }

    @And("The user enters amount and clicks the Pay button")
    public void theUserEntersAmountAndClicksThePayButton() {
    }

    @Then("The user views form to enter card details")
    public void theUserViewsFormToEnterCardDetails() {
    }

    @When("The user enters card details and completes the payment")
    public void theUserEntersCardDetailsAndCompletesThePayment() {
    }

    @Then("The user views a message that the payment was successfully completed")
    public void theUserViewsAMessageThatThePaymentWasSuccessfullyCompleted() {
    }

    @Then("The user verifies that the payment has been completed")
    public void theUserVerifiesThatThePaymentHasBeenCompleted() {
    }

    @When("The user clicks the New Message button in the top right corner of the toolbar")
    public void theUserClicksTheNewMessageButtonInTheTopRightCornerOfTheToolbar() {
    }

    @Then("The user views the received message in the area")
    public void theUserViewsTheReceivedMessageInTheArea() {
    }
}
