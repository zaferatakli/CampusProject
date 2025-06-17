package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.DialogContent;
import pages.TopNav;
import utilities.ConfigReader;
import utilities.GWD;

import java.util.List;

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

    @And("The page is checked")
    public void thePageIsChecked() {
        dc.verifyContainsText(dc.studentFees, "Students Fees");
    }

    @When("The user clicks on their payment in processing")
    public void theUserClicksOnTheirPaymentInProcessing() {
        Assert.assertTrue(dc.processingPayment.isDisplayed(), "Processing payment is not displayed!");
        dc.myClick(dc.processingPayment);
    }

    @Then("The user verify that you go to the Student Fee page")
    public void theUserVerifyThatYouGoToTheStudentFeePage() {
        dc.verifyContainsText(dc.studentFee, "Student Fee");
    }


    @And("The user clicks on the following buttons to reach the pay button")
    public void theUserClicksOnTheFollowingButtonsToReachThePayButton(DataTable buttons) {
        List<String> buttonsList = buttons.asList(String.class);

        for (int i = 0; i < buttonsList.size(); i++) {
            dc.wait.until(ExpectedConditions.elementToBeClickable(dc.getWebElement(buttonsList.get(i))));
            Assert.assertTrue(dc.getWebElement(buttonsList.get(i)).isDisplayed());
            dc.myClick(dc.getWebElement(buttonsList.get(i)));
        }

    }

    @And("The user enter the payment amount in the Amount field.")
    public void theUserEnterThePaymentAmountInTheAmountField() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.amountField));
        Assert.assertTrue(dc.amountField.isDisplayed(), "Amount Field is not displayed!");
        dc.mySendKeys(dc.amountField, ConfigReader.getProperty("amount"));
    }

    @And("The user double click on the pay button")
    public void theUserDoubleClickOnThePayButton() {
        dc.myClick(dc.payButton);
        dc.myClick(dc.paymentButton);
    }

    @When("The user verifies that the field to enter credit card information has been opened")
    public void theUserVerifiesThatTheFieldToEnterCreditCardInformationHasBeenOpened() {
        dc.verifyContainsText(dc.cardPaymentTitle, "Pay $");
    }

    @And("The user enters credit card details")
    public void theUserEntersCreditCardDetails() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.paymentIframe));
        GWD.getDriver().switchTo().frame(dc.paymentIframe);
        dc.wait.until(ExpectedConditions.visibilityOfAllElements(dc.creditCardField));
        dc.mySendKeys(dc.cardNumberInput, ConfigReader.getProperty("cardNumber")
                + Keys.TAB + ConfigReader.getProperty("expirationDate")
                + Keys.TAB + ConfigReader.getProperty("securityCode"));
        GWD.getDriver().switchTo().defaultContent();

    }

    @And("The user clicks on the stipe payments button")
    public void theUserClicksOnTheStipePaymentsButton() {
        dc.myClick(dc.paymentsButton);
    }

    @And("The user sees the message of success")
    public void theUserSeesTheMessageOfSuccess() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.paymentSuccessMessage));
        dc.verifyContainsText(dc.paymentSuccessMessage, "success");
    }

    @Given("The user clicks on the button with three dots in the lower left corner")
    public void theUserClicksOnTheButtonWithThreeDotsInTheLowerLeftCorner() {
        Assert.assertTrue(dc.threeDotButton.isDisplayed());
        dc.myClick(dc.threeDotButton);
    }

    @And("the user downloads the document by clicking the Excel Export button in the drop-down menu")
    public void theUserDownloadsTheDocumentByClickingTheExcelExportButtonInTheDropDownMenu() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.excelDownload));
        Assert.assertTrue(dc.excelDownload.isDisplayed(), "Excel download button not displayed");
        dc.myClick(dc.excelDownload);
    }

    @And("the user downloads the document by clicking the Pdf Export button in the drop-down menu")
    public void theUserDownloadsTheDocumentByClickingThePdfExportButtonInTheDropDownMenu() {
        dc.wait.until(ExpectedConditions.visibilityOf(dc.pdfDownload));
        Assert.assertTrue(dc.pdfDownload.isDisplayed(), "Pdf download button not displayed");
        dc.myClick(dc.pdfDownload);
    }
}
